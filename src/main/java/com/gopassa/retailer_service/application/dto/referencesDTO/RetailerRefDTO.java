package com.gopassa.retailer_service.application.dto.referencesDTO;

import com.gopassa.retailer_service.domain.entities.Retailer;
import lombok.Data;

@Data
public class RetailerRefDTO {
    private final String id;
    private final String tenantId;
    private final String name;
    private final String acronym;

    public static RetailerRefDTO create(Retailer retailer){
        return new RetailerRefDTO(
                retailer.getId(),
                retailer.getTenantId(),
                retailer.getName(),
                retailer.getAcronym()
        );
    }
}
