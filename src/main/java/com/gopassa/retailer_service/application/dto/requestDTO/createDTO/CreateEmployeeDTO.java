package com.gopassa.retailer_service.application.dto.requestDTO.createDTO;

import com.gopassa.retailer_service.application.dto.domainDTO.RetailerDTO;
import com.gopassa.retailer_service.domain.entities.Device;
import com.gopassa.retailer_service.domain.entities.Employee;
import com.gopassa.retailer_service.infrastructure.validator.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateEmployeeDTO {

    @NotNull(message = "The first name must be filled.")
    @Size(min = 3, max = 50)
    private final String firstName;

    @NotNull(message = "The first name must be filled.")
    @Size(min = 3, max = 50)
    private final String lastName;


    @NotNull(message = "The email must be filled.")
    @Email
    @UniqueValue(
        entity = Employee.class,
        fieldName = "email",
        message = "The email is already being used."
    )
    private final String email;

    @UniqueValue(
        entity = Employee.class,
        fieldName = "email",
        message = "The mobile number is already being used."
    )
    private final String mobileNumber;

    @NotNull(message = "The position must be filled.")
    @Size(min = 3, max = 30)
    private final String position;

    @NotNull(message = "The Tenant ID must be filled.")
    @Size(min = 36, max = 36)
    private final String tenantId;

    @NotNull(message = "The Tenant ID must be filled.")
    @Size(min = 36, max = 36)
    @UniqueValue(
        entity = Employee.class,
        fieldName = "userId",
        message = "The user already exists."
    )
    private final String userId;

    @NotNull(message = "The Retailer must be indicated.")
    @Size(min = 36, max = 36)
    private final String retailerId;

    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}
