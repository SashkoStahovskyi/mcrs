package com.stakhovskyi.inventoryservice.controller;

import com.stakhovskyi.inventoryservice.dto.InventoryResponse;
import com.stakhovskyi.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/inventory", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    protected List<InventoryResponse> isInStock(@RequestParam List<String> skucode) {
        return inventoryService.isInStock(skucode);
    }

}
