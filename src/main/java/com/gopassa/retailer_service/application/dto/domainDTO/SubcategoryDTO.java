package com.gopassa.retailer_service.application.dto.domainDTO;

import com.gopassa.retailer_service.application.dto.referencesDTO.CategoryRefDTO;
import com.gopassa.retailer_service.application.dto.referencesDTO.RetailerRefDTO;
import com.gopassa.retailer_service.domain.entities.Category;
import com.gopassa.retailer_service.domain.entities.Subcategory;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubcategoryDTO {

    private final String id;
    private final String designation;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final CategoryRefDTO retailer;


    public static SubcategoryDTO  create(Subcategory subcategory) {
        return new SubcategoryDTO(
                subcategory.getId(),
                subcategory.getDesignation(),
                subcategory.getCreatedAt(),
                subcategory.getUpdatedAt(),
                CategoryRefDTO.create(subcategory.getCategory())
        );
    }
}
