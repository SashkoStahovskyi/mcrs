package com.stakhovskyi.productservice.controller;

import com.stakhovskyi.productservice.dto.ProductDto;
import com.stakhovskyi.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    protected void createProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    protected List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    protected ProductDto getProductById(@PathVariable("id") String id) {
        return productService.getProductById(id);
    }



    @PutMapping("/{id}")
    protected ProductDto updateProduct(@RequestBody ProductDto productDto,
                                       @PathVariable("id") String id) {
        return productService.updateProduct(productDto, id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id}")
    protected void deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(id);
    }


}
