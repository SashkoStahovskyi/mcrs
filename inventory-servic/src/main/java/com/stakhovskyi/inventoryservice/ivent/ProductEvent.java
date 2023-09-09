package com.stakhovskyi.inventoryservice.ivent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEvent {

    private String id;
    private String name;
    private int quantity;

}
