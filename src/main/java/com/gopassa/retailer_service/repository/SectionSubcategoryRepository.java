package com.gopassa.retailer_service.repository;

import com.gopassa.retailer_service.domain.entities.SectionSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SectionSubcategoryRepository extends JpaRepository<SectionSubcategory, String> {

    Optional<SectionSubcategory> findBySectionIdAndSubcategoryId(String sectionId, String subcategoryId);

}
