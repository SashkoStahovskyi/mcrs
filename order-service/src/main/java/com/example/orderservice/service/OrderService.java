package com.example.orderservice.service;

import com.example.orderservice.dto.OrderLineItemsDto;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.entity.Order;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.repository.OrderRepository;
import com.stakhovskyi.grpc.InventoryServiceGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

   // private final InventoryServiceGrpc.InventoryServiceBlockingStub stub;

    public boolean placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber((UUID.randomUUID().toString()));

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtos()
                .stream()
                .map(this::mapToOrder)
                .collect(toList());

        order.setOrderLineItems(orderLineItems);

        // how get sku-code
        String skucode = orderLineItems.get(0).getSkuCode();

        ManagedChannel managedChannel = ManagedChannelBuilder.forTarget("localhost:8090")
                .usePlaintext()
                .build();
        InventoryServiceGrpc.InventoryServiceBlockingStub stub = InventoryServiceGrpc.newBlockingStub(managedChannel);

        // create and inject into request builder sku-code
        com.stakhovskyi.grpc.Order.InventoryRequest request = com.stakhovskyi.grpc.Order.InventoryRequest
                .newBuilder().setSkuCode(skucode).build();

        // here we check if order on stock
        com.stakhovskyi.grpc.Order.InventoryResponse response = stub.isInStock(request);
        managedChannel.shutdownNow();
        log.info(" Manager Channel is Shutdown !");

        if (response.getInStock()) {
            orderRepository.save(order);
            log.info(" Save order {} in db ", order.getOrderNumber());
            return true;
        }
        return false;
    }

    private OrderLineItems mapToOrder(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());

        return orderLineItems;
    }
}
