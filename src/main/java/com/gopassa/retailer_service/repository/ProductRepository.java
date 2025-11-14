package com.gopassa.retailer_service.repository;

import com.gopassa.retailer_service.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
