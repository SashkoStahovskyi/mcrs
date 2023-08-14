package com.stakhovskyi.productservice.service;

import com.stakhovskyi.productservice.dto.ProductDto;
import com.stakhovskyi.productservice.ivent.ProductEvent;
import com.stakhovskyi.productservice.massageservice.ProductMassageService;
import com.stakhovskyi.productservice.model.Product;
import com.stakhovskyi.productservice.repository.ProductRepository;
import com.stakhovskyi.productservice.utils.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMassageService massageService;


    public void createProduct(ProductDto productDto) {
        Product product = productRepository.save(ProductMapper.toProduct(productDto));

        ProductEvent productEvent = ProductEvent.builder()
                .id(product.getId())
                .name(product.getName())
                .quantity(product.getQuantity())
                .build();

        massageService.createProductMassage(productEvent);
    }

    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toProductDto)
                .toList();
    }

    public ProductDto updateProduct(ProductDto productDto, String id) {
        ProductDto resultProductDto = productRepository.findById(id)
                .map(p -> ProductMapper.updateProduct(p, productDto))
                .map(productRepository::save)
                .map(ProductMapper::toProductDto)
                .orElseThrow(() -> new RuntimeException(" Product with id: " + id + " not exist in db!"));

        massageService.updateProductMassage(ProductEvent.builder()
                .id(id)
                .name(productDto.getName())
                .quantity(productDto.getQuantity())
                .build());
        return resultProductDto;
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
        massageService.deleteProductMassage(ProductEvent.builder()
                .id(id)
                .build());
    }

    public ProductDto getProductById(String id) {
        return productRepository.findById(id)
                .map(ProductMapper::toProductDto)
                .orElseThrow(() -> new RuntimeException(" Product with id: " + id + " not exist in db!"));
    }
}
