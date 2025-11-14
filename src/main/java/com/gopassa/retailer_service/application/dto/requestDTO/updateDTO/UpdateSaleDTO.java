package com.gopassa.retailer_service.application.dto.requestDTO.updateDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateSaleDTO {

    @NotBlank(message = "This field cannot be empty")
    @NotNull(message = "The status must be provided.")
    @Size(min = 7, max = 10)
    private final String status;
}
