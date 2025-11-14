package com.gopassa.retailer_service.application.dto.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SaveProductImageDTO {

    @NotBlank(message = "The image URL must be provided")
    @NotNull(message = "The image URL must be provided")
    @Size(min = 6, max = 515)
    private final String imageUrl;
    private final Boolean isPrimary;
    private final String angle;
    private final String lightingCondition;
    private final String resolution;
    private final String source;

    @NotBlank(message = "The product must be indicated")
    @NotNull(message = "The product must be indicated")
    private final String productId;
}
