package com.gopassa.retailer_service.application.dto.referencesDTO;

import com.gopassa.retailer_service.application.dto.domainDTO.SubcategoryDTO;
import com.gopassa.retailer_service.domain.entities.Subcategory;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubcategoryRefDTO {

    private final String id;
    private final String designation;
    private final CategoryRefDTO retailer;

    public static SubcategoryRefDTO create(Subcategory subcategory) {
        return new SubcategoryRefDTO(
                subcategory.getId(),
                subcategory.getDesignation(),
                CategoryRefDTO.create(subcategory.getCategory())
        );
    }

}
