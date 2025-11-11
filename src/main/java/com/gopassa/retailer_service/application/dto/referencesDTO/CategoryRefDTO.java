package com.gopassa.retailer_service.application.dto.referencesDTO;

import com.gopassa.retailer_service.application.dto.domainDTO.CategoryDTO;
import com.gopassa.retailer_service.domain.entities.Category;
import lombok.Data;

@Data
public class CategoryRefDTO {
    private final String id;
    private final String designation;
    private final RetailerRefDTO retailer;

    public static CategoryRefDTO create(Category category) {
        return new CategoryRefDTO(
                category.getId(),
                category.getDesignation(),
                RetailerRefDTO.create(category.getRetailer())
        );
    }
}
