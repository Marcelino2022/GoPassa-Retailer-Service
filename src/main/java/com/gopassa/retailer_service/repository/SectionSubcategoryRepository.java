package com.gopassa.retailer_service.repository;

import com.gopassa.retailer_service.domain.entities.SectionSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionSubcategoryRepository extends JpaRepository<SectionSubcategory, String> {
}
