package com.gopassa.retailer_service.repository;

import com.gopassa.retailer_service.domain.entities.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<Subcategory, String> {
}
