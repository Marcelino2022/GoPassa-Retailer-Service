package com.gopassa.retailer_service.application.dto.domainDTO;

import com.gopassa.retailer_service.application.dto.referencesDTO.RetailerRefDTO;
import com.gopassa.retailer_service.domain.entities.Employee;
import com.gopassa.retailer_service.domain.entities.Section;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class SectionDTO {
    private final String id;
    private final String designation;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final RetailerRefDTO retailer;


    public static SectionDTO  create(Section section) {
        return new SectionDTO(
                section.getId(),
                section.getDesignation(),
                section.getCreatedAt(),
                section.getUpdatedAt(),
                RetailerRefDTO.create(section.getRetailer())
        );
    }
}
