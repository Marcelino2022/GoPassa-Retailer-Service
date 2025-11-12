package com.gopassa.retailer_service.repository;

import com.gopassa.retailer_service.domain.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, String> {
}
