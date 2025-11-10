package com.gopassa.retailer_service.application.dto.requestDTO.updateDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateSectionDTO {

    @NotNull
    @Size(min = 1, max = 30)
    private final String designation;

    private final LocalDateTime updatedAt;
}
