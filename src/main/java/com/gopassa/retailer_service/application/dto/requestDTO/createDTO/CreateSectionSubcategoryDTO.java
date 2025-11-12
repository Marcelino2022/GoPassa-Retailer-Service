package com.gopassa.retailer_service.application.dto.requestDTO.createDTO;

import com.gopassa.retailer_service.domain.entities.Section;
import com.gopassa.retailer_service.domain.entities.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreateSectionSubcategoryDTO {
    private final String sectionId;
    private final String subcategoryId;

}
