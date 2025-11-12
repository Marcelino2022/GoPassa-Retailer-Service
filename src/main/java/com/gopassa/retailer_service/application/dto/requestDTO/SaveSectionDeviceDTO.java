package com.gopassa.retailer_service.application.dto.requestDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SaveSectionDeviceDTO {
    @NotNull(message = "The Section must be indicated.")
    @Size(min = 36, max = 36)
    private String sectionId;

    @NotNull(message = "The Device must be indicated.")
    @Size(min = 36, max = 36)
    private String deviceId;
}
