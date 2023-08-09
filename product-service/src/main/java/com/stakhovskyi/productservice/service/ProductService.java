package com.stakhovskyi.productservice.service;

import com.stakhovskyi.productservice.dto.ProductRequest;
import com.stakhovskyi.productservice.dto.ProductRespone;
import com.stakhovskyi.productservice.model.Product;
import com.stakhovskyi.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProducerMassageService producerMassageService;


    public void createProduct(ProductRequest productRequest) {

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        producerMassageService.sendMessage("Product" + product.getName() + " was created! ");

    }

    public List<ProductRespone> getProducts() {

        return productRepository.findAll().stream()
                .map(this::mapToProductRespone)
                .toList();
    }

    private ProductRespone mapToProductRespone(Product product) {

        return ProductRespone.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }


}
