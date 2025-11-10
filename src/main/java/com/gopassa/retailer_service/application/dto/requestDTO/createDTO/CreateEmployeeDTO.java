package com.gopassa.retailer_service.application.dto.requestDTO.createDTO;

import com.gopassa.retailer_service.application.dto.domainDTO.RetailerDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateEmployeeDTO {

    @NotNull
    @NotNull(message = "The first name must be filled.")
    @Size(min = 3, max = 50)
    private final String firstName;

    @NotNull(message = "The first name must be filled.")
    @Size(min = 3, max = 50)
    private final String lastName;

    @NotNull(message = "The email must be filled.")
    private final String email;

    private final String mobileNumber;

    @NotNull(message = "The position must be filled.")
    @Size(min = 3, max = 30)
    private final String position;

    @NotNull(message = "The Tenant ID must be filled.")
    @Size(min = 36, max = 36)
    private final String tenantId;

    @NotNull(message = "The Tenant ID must be filled.")
    @Size(min = 36, max = 36)
    private final String userId;

    @NotNull(message = "The Retailer must be indicated.")
    @Size(min = 36, max = 36)
    private final String retailerId;

    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}
