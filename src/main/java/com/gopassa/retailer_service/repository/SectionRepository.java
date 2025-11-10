package com.gopassa.retailer_service.repository;

import com.gopassa.retailer_service.domain.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, String> {
}
