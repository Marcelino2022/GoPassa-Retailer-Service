package com.gopassa.retailer_service.application.dto.requestDTO.createDTO;

import com.gopassa.retailer_service.domain.entities.Device;
import com.gopassa.retailer_service.domain.entities.Sale;
import com.gopassa.retailer_service.infrastructure.validator.UniqueValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreateSaleDTO {
    @NotBlank(message = "This field cannot be empty")
    @NotNull(message = "The total amount must be provided.")
    private final BigDecimal totalAmount;

    @Size(min = 7, max = 10)
    private final String status;

    @NotBlank(message = "This field cannot be empty")
    @NotNull(message = "The purchase reference must be provided.")
    @Size(min = 36, max = 36)
    @UniqueValue(
        entity = Sale.class,
        fieldName = "iotDeviceId",
        message = "The purchase is already registered."
    )
    private final String purchaseId;

    @NotBlank(message = "This field cannot be empty")
    @NotNull(message = "The retailer reference must be provided.")
    @Size(min = 36, max = 36)
    private final String retailerId;
}
