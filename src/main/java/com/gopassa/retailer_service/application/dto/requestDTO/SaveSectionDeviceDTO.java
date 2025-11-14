package com.gopassa.retailer_service.application.dto.requestDTO;
import com.gopassa.retailer_service.domain.entities.SectionDevice;
import com.gopassa.retailer_service.infrastructure.validator.UniqueValue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SaveSectionDeviceDTO {
    @NotNull(message = "The Section must be indicated.")
    @Size(min = 36, max = 36, message = "Invalid Section")
    private String sectionId;

    @NotNull(message = "The Device must be indicated.")
    @Size(min = 36, max = 36, message = "Invalid Section")
    @UniqueValue(
            entity = SectionDevice.class,
            fieldName = "device.id",
            message = "This device is already linked to a section."
    )
    private String deviceId;
}
