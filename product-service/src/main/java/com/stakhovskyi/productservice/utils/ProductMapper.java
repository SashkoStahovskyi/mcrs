package com.stakhovskyi.productservice.utils;

import com.stakhovskyi.productservice.dto.ProductDto;
import com.stakhovskyi.productservice.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {


    public static Product toProduct(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }

    public static ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product updateProduct(Product product, ProductDto productDto) {
        BeanUtils.copyProperties(productDto, product);
        return product;
    }




}
