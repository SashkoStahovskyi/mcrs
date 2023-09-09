package com.example.orderservice.service;

import com.example.orderservice.dto.InventoryResponse;
import com.example.orderservice.dto.OrderLineItemsDto;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.entity.Order;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.serviceclient.ServiceClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final ServiceClient inventoryServiceClient;

    public String placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber((UUID.randomUUID().toString()));

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtos()
                .stream()
                .map(this::mapToOrder)
                .collect(toList());

        order.setOrderLineItems(orderLineItems);

        List<String> skucodeList = orderLineItems.stream()
                .map(OrderLineItems::getSkuCode)
                .collect(toList());

        boolean isInStock = Arrays.stream(inventoryServiceClient.isInStock(skucodeList))
                .allMatch(InventoryResponse::isInStock);

        if (isInStock) {
            orderRepository.save(order);
            log.info(" Place order {} to OrderService db", order.getOrderNumber());
            return "Order Placed successfully!";
        }
        throw new RuntimeException("Order not in stock!");
    }

    private OrderLineItems mapToOrder(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());

        return orderLineItems;
    }


}
