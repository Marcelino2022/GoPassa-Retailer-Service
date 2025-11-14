package com.gopassa.retailer_service.application.dto.domainDTO;

import com.gopassa.retailer_service.application.dto.referencesDTO.ProductRefDTO;
import com.gopassa.retailer_service.domain.entities.ProductImage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductImageDTO {
    private final String id;
    private final String imageUrl;
    private final Boolean isPrimary;
    private final String angle;
    private final String lightingCondition;
    private final String resolution;
    private final String source;
    private final LocalDateTime createdAt;
    private final ProductRefDTO product;

    public static ProductImageDTO create(ProductImage productImage) {
        return new ProductImageDTO(
                productImage.getId(),
                productImage.getImageUrl(),
                productImage.getIsPrimary(),
                productImage.getAngle(),
                productImage.getLightingCondition(),
                productImage.getResolution(),
                productImage.getSource(),
                productImage.getCreatedAt(),
                ProductRefDTO.create(productImage.getProduct())
        );
    }
}
