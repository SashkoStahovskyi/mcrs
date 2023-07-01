package com.stakhovskyi.productservice.repository;

import com.stakhovskyi.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
