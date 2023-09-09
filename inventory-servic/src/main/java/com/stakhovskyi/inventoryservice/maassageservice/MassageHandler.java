package com.stakhovskyi.inventoryservice.maassageservice;

import com.stakhovskyi.inventoryservice.ivent.ProductEvent;
import com.stakhovskyi.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class MassageHandler implements MassageService {

    private final InventoryService inventoryService;


    @KafkaListener(topics = "create_product", groupId = "inventory_group_id")
    @Override
    public void createTopicEvent(ProductEvent productEvent,
                                 @Header(KafkaHeaders.RECEIVED_PARTITION) String partition) {
        log.info(" inventory service accept create product event: {}, partition {}", productEvent.toString(), partition);
        inventoryService.createProduct(productEvent);

    }

    @KafkaListener(topics = "update_product", groupId = "inventory_group_id")
    @Override
    public void updateTopicEvent(ProductEvent productEvent,
                                 @Header(KafkaHeaders.RECEIVED_PARTITION) String partition) {
        log.info(" inventory service accept update product event: {}, partition {}", productEvent.toString(), partition);
        inventoryService.updateProduct(productEvent);
    }

    @KafkaListener(topics = "delete_product", groupId = "inventory_group_id")
    @Override
    public void deleteTopicEvent(ProductEvent productEvent,
                                 @Header(KafkaHeaders.RECEIVED_PARTITION) String partition) {
        log.info(" inventory service accept delete product event: {}, partition {}", productEvent.toString(), partition);
        inventoryService.deleteProduct(productEvent);
    }
}
