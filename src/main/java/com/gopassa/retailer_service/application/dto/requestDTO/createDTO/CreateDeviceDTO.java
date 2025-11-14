package com.gopassa.retailer_service.application.dto.requestDTO.createDTO;

import com.gopassa.retailer_service.domain.entities.Device;
import com.gopassa.retailer_service.domain.entities.SectionDevice;
import com.gopassa.retailer_service.infrastructure.validator.UniqueValue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateDeviceDTO {

    @NotNull(message = "The designation must be filled.")
    @Size(min = 1, max = 30, message = "The designation must be between 1 and 20 characters.")
    @UniqueValue(
            entity = Device.class,
            fieldName = "designation",
            message = "The designation is already being used."
    )
    private final String designation;

    @NotNull(message = "The type must be filled.")
    @Size(min = 3, max = 20, message = "The designation must be between 1 and 20 characters.")
    private final String type;

    private final Boolean status;

    @NotNull(message = "The IoT Device must be indicated.")
    @Size(min = 36, max = 36, message = "Invalid IoT Device reference")
    @UniqueValue(
            entity = Device.class,
            fieldName = "iotDeviceId",
            message = "The Device already exists."
    )
    private final String iotDeviceId;

    @NotNull(message = "The Retailer must be indicated.")
    @Size(min = 36, max = 36)
    private final String retailerId;

}
