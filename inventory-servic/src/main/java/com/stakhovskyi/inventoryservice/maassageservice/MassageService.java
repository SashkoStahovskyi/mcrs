package com.stakhovskyi.inventoryservice.maassageservice;

import com.stakhovskyi.inventoryservice.ivent.ProductEvent;


public interface MassageService {

    void createTopicEvent(ProductEvent productEvent, String partition);

    void updateTopicEvent(ProductEvent productEvent, String partition);

    void deleteTopicEvent(ProductEvent productEvent, String partition);
}
