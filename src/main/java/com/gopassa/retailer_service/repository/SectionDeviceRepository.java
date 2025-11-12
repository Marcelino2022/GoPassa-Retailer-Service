package com.gopassa.retailer_service.repository;

import com.gopassa.retailer_service.domain.entities.SectionDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionDeviceRepository extends JpaRepository<SectionDevice, String> {
}
