package com.gopassa.retailer_service.application.dto.referencesDTO;

import com.gopassa.retailer_service.application.dto.domainDTO.ProductDTO;
import com.gopassa.retailer_service.domain.entities.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRefDTO {
    private final String id;
    private final String designation;
    private final String brand;
    private final BigDecimal weight;
    private final String unitOfMeasure;
    private final String color;
    private final BigDecimal price;
    private final String barcode;
    private final RetailerRefDTO retailer;

    public static ProductRefDTO create(Product product) {
        return new ProductRefDTO(
                product.getId(),
                product.getDesignation(),
                product.getBrand(),
                product.getWeight(),
                product.getUnitOfMeasure(),
                product.getColor(),
                product.getPrice(),
                product.getBarcode(),
                RetailerRefDTO.create(product.getRetailer())
        );
    }
}
