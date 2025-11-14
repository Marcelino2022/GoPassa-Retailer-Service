package com.gopassa.retailer_service.application.dto.referencesDTO;

import com.gopassa.retailer_service.domain.entities.Subcategory;
import lombok.Data;

@Data
public class ProductSubcategoryRefDTO {

    private final String id;
    private final String designation;

    public static ProductSubcategoryRefDTO create(Subcategory subcategory) {
        return new ProductSubcategoryRefDTO(
                subcategory.getId(),
                subcategory.getDesignation()
        );
    }

}
