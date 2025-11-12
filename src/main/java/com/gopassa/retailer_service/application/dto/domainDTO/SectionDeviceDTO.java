package com.gopassa.retailer_service.application.dto.domainDTO;

import com.gopassa.retailer_service.application.dto.referencesDTO.DeviceRefDTO;
import com.gopassa.retailer_service.application.dto.referencesDTO.SectionRefDTO;

import com.gopassa.retailer_service.domain.entities.SectionDevice;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SectionDeviceDTO {
    private final String id;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final SectionRefDTO Section;
    private final DeviceRefDTO device;

    public static SectionDeviceDTO create(SectionDevice sectionDevice) {
        return new SectionDeviceDTO(
                sectionDevice.getId(),
                sectionDevice.getCreatedAt(),
                sectionDevice.getUpdatedAt(),
                SectionRefDTO.create(sectionDevice.getSection()),
                DeviceRefDTO.create(sectionDevice.getDevice())
        );
    }
}
