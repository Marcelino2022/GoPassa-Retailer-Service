package com.gopassa.retailer_service.application.dto.domainDTO;

import com.gopassa.retailer_service.application.dto.referencesDTO.RetailerRefDTO;
import com.gopassa.retailer_service.domain.entities.Sale;
import com.gopassa.retailer_service.domain.enums.SaleStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SaleDTO {
    private final String id;
    private final BigDecimal totalAmount;
    private final SaleStatus status;
    private final String purchaseId;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final RetailerRefDTO retailer;

    public static SaleDTO create(Sale sale) {
        return new SaleDTO(
                sale.getId(),
                sale.getTotalAmount(),
                sale.getStatus(),
                sale.getPurchaseId(),
                sale.getCreatedAt(),
                sale.getUpdatedAt(),
                RetailerRefDTO.create(sale.getRetailer())
        );
    }

}
