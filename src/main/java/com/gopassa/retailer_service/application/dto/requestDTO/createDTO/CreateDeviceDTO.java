package com.gopassa.retailer_service.application.dto.requestDTO.createDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateDeviceDTO {

    @NotNull(message = "The designation must be filled.")
    @Size(min = 3, max = 30)
    private final String designation;

    @NotNull(message = "The type must be filled.")
    @Size(min = 3, max = 20)
    private final String type;

    private final Boolean status;

    @NotNull(message = "The IoT Device must be indicated.")
    @Size(min = 3, max = 20)
    private final String iotDeviceId;

    @NotNull(message = "The Retailer must be indicated.")
    @Size(min = 36, max = 36)
    private final String retailerId;

}
