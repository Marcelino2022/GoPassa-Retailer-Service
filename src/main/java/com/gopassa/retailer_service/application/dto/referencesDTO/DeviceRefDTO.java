package com.gopassa.retailer_service.application.dto.referencesDTO;

import com.gopassa.retailer_service.domain.entities.Device;
import com.gopassa.retailer_service.domain.entities.Retailer;
import com.gopassa.retailer_service.domain.entities.Subcategory;
import lombok.Data;

@Data
public class DeviceRefDTO {

    private final String id;
    private final String designation;
    private final RetailerRefDTO retailer;

    public static DeviceRefDTO create(Device device) {
        return new DeviceRefDTO(
                device.getId(),
                device.getDesignation(),
                RetailerRefDTO.create(device.getRetailer())
        );
    }
}
