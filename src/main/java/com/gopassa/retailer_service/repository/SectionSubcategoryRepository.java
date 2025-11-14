package com.gopassa.retailer_service.repository;

import com.gopassa.retailer_service.domain.entities.SectionSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectionSubcategoryRepository extends JpaRepository<SectionSubcategory, String> {

    Optional<SectionSubcategory> findBySectionIdAndSubcategoryId(String sectionId, String subcategoryId);

}
