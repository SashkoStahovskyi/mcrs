package com.stakhovskyi.inventoryservice.service;

import com.stakhovskyi.inventoryservice.repository.InventoryRepository;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Builder
@Component
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {

        boolean result = inventoryRepository.findBySkuCode(skuCode).isPresent();
        log.info(" Fetch data from inventory DB , value is :{} !", result);
        return result;
    }

    public void saveNewProductInStock() {
      /*  massageListenerService.consume();*/

    }

}

