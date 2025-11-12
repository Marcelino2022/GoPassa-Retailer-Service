package com.gopassa.retailer_service.application.dto.domainDTO;

import com.gopassa.retailer_service.application.dto.referencesDTO.RetailerRefDTO;
import com.gopassa.retailer_service.domain.entities.Device;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeviceDTO {
    private final String id;
    private final String designation;
    private final String type;
    private final Boolean status;
    private final String iotDeviceId;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final RetailerRefDTO retailer;

    public static DeviceDTO create(Device gopassaDevice) {
        return new DeviceDTO(
                gopassaDevice.getId(),
                gopassaDevice.getDesignation(),
                gopassaDevice.getType(),
                gopassaDevice.getStatus(),
                gopassaDevice.getIotDeviceId(),
                gopassaDevice.getCreatedAt(),
                gopassaDevice.getUpdatedAt(),
                RetailerRefDTO.create(gopassaDevice.getRetailer())
        );
    }
}
