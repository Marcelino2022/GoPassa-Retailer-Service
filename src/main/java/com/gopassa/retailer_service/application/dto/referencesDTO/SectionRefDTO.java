package com.gopassa.retailer_service.application.dto.referencesDTO;

import com.gopassa.retailer_service.application.dto.domainDTO.SectionDTO;
import com.gopassa.retailer_service.domain.entities.Section;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SectionRefDTO {

    private final String id;
    private final String designation;
    private final RetailerRefDTO retailer;

    public static SectionRefDTO create(Section section) {
        return new SectionRefDTO(
            section.getId(),
            section.getDesignation(),
            RetailerRefDTO.create(section.getRetailer())
        );
    }
}
