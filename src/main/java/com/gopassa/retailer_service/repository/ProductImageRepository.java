package com.gopassa.retailer_service.repository;

import com.gopassa.retailer_service.domain.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, String> {
}
