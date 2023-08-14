package com.stakhovskyi.inventoryservice.controller;

import com.stakhovskyi.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/inventory", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;


    @GetMapping("/{productName}")
    @ResponseStatus(HttpStatus.OK)
    protected boolean isInStock(@PathVariable("productName") String productName) {
        return inventoryService.isInStock(productName);
    }

}
