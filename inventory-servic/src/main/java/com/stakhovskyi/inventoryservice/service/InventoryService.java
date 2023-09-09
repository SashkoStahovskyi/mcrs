package com.stakhovskyi.inventoryservice.service;

import com.stakhovskyi.inventoryservice.ivent.ProductEvent;
import com.stakhovskyi.inventoryservice.dto.InventoryResponse;
import com.stakhovskyi.inventoryservice.repository.InventoryRepository;
import com.stakhovskyi.inventoryservice.utils.AppUtils;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Builder
@Component
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public List<InventoryResponse> isInStock(List<String> skucodeList) {
        return inventoryRepository.findByNameIn(skucodeList).stream()
                .map(product -> InventoryResponse.builder()
                        .skucode(product.getName())
                        .inStock(product.getQuantity() > 0)
                        .build())
                .collect(Collectors.toList());
    }

    public void createProduct(ProductEvent productEvent) {
        inventoryRepository.save(AppUtils.toProduct(productEvent));
        log.info(" Create new Product in DB -> {}", productEvent.getName());
    }

    public void updateProduct(ProductEvent productEvent) {
        inventoryRepository.findById(productEvent.getId())
                .map(product -> AppUtils.updateProduct(productEvent))
                .map(inventoryRepository::save)
                .orElseThrow(() -> new RuntimeException(" Product with id: " + productEvent.getId() + " not exist in inventory DB"));
        log.info("Update Product : {}", productEvent.getName());
    }

    public void deleteProduct(ProductEvent productEvent) {
        inventoryRepository.deleteById(productEvent.getId());
        log.info("Delete product with id: {}", productEvent.getId());
    }

}

