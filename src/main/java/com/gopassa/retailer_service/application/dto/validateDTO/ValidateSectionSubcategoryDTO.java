package com.gopassa.retailer_service.application.dto.validateDTO;

import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateSectionSubcategoryDTO;
import lombok.Data;

public class ValidateSectionSubcategoryDTO extends CreateSectionSubcategoryDTO {
    public ValidateSectionSubcategoryDTO(String sectionId, String subcategoryId) {
        super(sectionId, subcategoryId);
    }
}
