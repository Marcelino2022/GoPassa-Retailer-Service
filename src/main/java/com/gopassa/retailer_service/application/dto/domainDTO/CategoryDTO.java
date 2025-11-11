package com.gopassa.retailer_service.application.dto.domainDTO;

import com.gopassa.retailer_service.application.dto.referencesDTO.RetailerRefDTO;
import com.gopassa.retailer_service.domain.entities.Category;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoryDTO {

    private final String id;
    private final String designation;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final RetailerRefDTO retailer;


    public static CategoryDTO  create(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getDesignation(),
                category.getCreatedAt(),
                category.getUpdatedAt(),
                RetailerRefDTO.create(category.getRetailer())
        );
    }
}
