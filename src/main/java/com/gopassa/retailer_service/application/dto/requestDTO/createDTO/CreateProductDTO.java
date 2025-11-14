package com.gopassa.retailer_service.application.dto.requestDTO.createDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class CreateProductDTO {

    @NotBlank(message = "The designation must be filled")
    @NotNull(message = "The designation must be filled")
    @Size(min= 2, max = 150)
    private final String designation;
    private final String brand;
    private final BigDecimal weight;
    private final String unitOfMeasure;
    private final String color;

    @NotBlank(message = "The designation must be filled")
    @NotNull(message = "The designation must be filled")
    private final BigDecimal price;

    private final int quantity;
    private final String barcode;
    private final String sku;
    private final int minStockLevel;
    private final int maxStockLevel;
    private final Boolean active;
    private final BigDecimal taxRate;
    private final BigDecimal discountRate;
    private final String discountCondition;
    private final LocalDate expiryDate;


    @NotBlank(message = "The retailer must be indicated")
    @NotNull(message = "The retailer must be indicated")
    @Size(min= 36, max = 36)
    private final String retailerId;

    @Size(max = 300)
    private final String description;

    @NotBlank(message = "The subcategory must be indicated")
    @NotNull(message = "The subcategory must be filled")
    @Size(min= 36, max = 36)
    private final String subcategoryId;
}
