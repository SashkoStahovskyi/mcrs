package com.stakhovskyi.inventoryservice.service;

import com.stakhovskyi.inventoryservice.ivent.ProductEvent;
import com.stakhovskyi.inventoryservice.repository.InventoryRepository;
import com.stakhovskyi.inventoryservice.utils.AppUtils;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Builder
@Component
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String productName) {
        boolean result = inventoryRepository.findByName(productName).isPresent();
        log.info(" Fetch data from inventory DB , name is :{} !", result);
        return result;
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

