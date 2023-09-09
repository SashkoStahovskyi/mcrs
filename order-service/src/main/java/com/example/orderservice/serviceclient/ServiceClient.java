package com.example.orderservice.serviceclient;

import com.example.orderservice.dto.InventoryResponse;

import java.util.List;

public interface ServiceClient {


    InventoryResponse[] isInStock(List<String> skucodeList);

}
