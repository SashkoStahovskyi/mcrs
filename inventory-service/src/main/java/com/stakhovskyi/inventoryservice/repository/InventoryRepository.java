package com.stakhovskyi.inventoryservice.repository;

import com.stakhovskyi.inventoryservice.module.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Product, String> {

    @Query(value = "SELECT p FROM Product p WHERE p.name =:productName")
    Optional<Object> findByName(@Param("productName") String productName);
}
