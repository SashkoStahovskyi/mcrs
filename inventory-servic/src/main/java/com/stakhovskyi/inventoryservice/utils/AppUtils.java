package com.stakhovskyi.inventoryservice.utils;

import com.stakhovskyi.inventoryservice.ivent.ProductEvent;
import com.stakhovskyi.inventoryservice.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AppUtils {

    public static Product toProduct(ProductEvent productEvent) {
        Product product = new Product();
        BeanUtils.copyProperties(productEvent, product);
        return product;
    }

    public static Product updateProduct(ProductEvent productEvent) {
        Product product = new Product();
        BeanUtils.copyProperties(productEvent, product);
        return product;
    }

}
