package com.gopassa.retailer_service.repository;

import com.gopassa.retailer_service.domain.entities.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, String> {
}
