package com.gopassa.retailer_service.application.dto.domainDTO;

import com.gopassa.retailer_service.application.dto.referencesDTO.ProductSubcategoryRefDTO;
import com.gopassa.retailer_service.application.dto.referencesDTO.RetailerRefDTO;
import com.gopassa.retailer_service.domain.entities.Product;
import com.gopassa.retailer_service.domain.enums.DiscountCondition;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ProductDTO {
    private final String id;
    private final String designation;
    private final String brand;
    private final BigDecimal weight;
    private final String unitOfMeasure;
    private final String color;
    private final BigDecimal price;
    private final int quantity;
    private final String barcode;
    private final String sku;
    private final int minStockLevel;
    private final int maxStockLevel;
    private final Boolean active;
    private final BigDecimal taxRate;
    private final BigDecimal discountRate;
    private final DiscountCondition discountCondition;
    private final LocalDate expiryDate;
    private final String description;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final RetailerRefDTO retailer;
    private final ProductSubcategoryRefDTO subcategory;

    public static ProductDTO create(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getDesignation(),
                product.getBrand(),
                product.getWeight(),
                product.getUnitOfMeasure(),
                product.getColor(),
                product.getPrice(),
                product.getQuantity(),
                product.getBarcode(),
                product.getSku(),
                product.getMinStockLevel(),
                product.getMaxStockLevel(),
                product.getActive(),
                product.getTaxRate(),
                product.getDiscountRate(),
                product.getDiscountCondition(),
                product.getExpiryDate(),
                product.getDescription(),
                product.getCreatedAt(),
                product.getUpdatedAt(),
                RetailerRefDTO.create(product.getRetailer()),
                ProductSubcategoryRefDTO.create(product.getSubcategory())
        );
    }
}
