package com.stakhovskyi.inventoryservice.repository;

import com.stakhovskyi.inventoryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Product, String> {

    // skucode same as product-name
    List<Product> findByNameIn(List<String> skucode);

}
