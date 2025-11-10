package com.gopassa.retailer_service.application.dto.requestDTO.createDTO;

import com.gopassa.retailer_service.application.dto.domainDTO.RetailerDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateSectionsDTO {

    @NotNull
    @Size(min = 1, max = 30)
    private final String designation;

    @NotNull
    @Size(min = 36, max = 36)
    private String retailerId;

    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}
