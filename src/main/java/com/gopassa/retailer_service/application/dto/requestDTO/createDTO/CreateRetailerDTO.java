package com.gopassa.retailer_service.application.dto.requestDTO.createDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateRetailerDTO {

    @NotNull
    @Size(min = 36, max = 36)
    private final String tenantId;

    @NotNull(message = "The name must be filled.")
    @Size(min = 2, max = 100)
    private final String name;

    @Size(min = 2, max = 6)
    private final String acronym;

    @NotNull(message = "The email must be filled.")
    private final String email;

    @NotNull(message = "The mobile number must be filled.")
    @Size(min = 9, max = 20)
    private final String mobileNumber;

    @Size(max = 20)
    private final String phoneNumber;

    @Size(max = 9)
    private final String nif;

    @NotNull(message = "The address must be filled")
    @Size(min = 5, max = 100)
    private final String address;

    @NotNull(message = "The post code must be filled")
    @Size(min = 8, max = 8)
    private final String postalCode;

    @NotNull(message = "The city must be filled.")
    @Size(min = 3, max = 100)
    private final String city;

    @NotNull(message = "The county must be filled.")
    @Size(min = 3, max = 100)
    private final String country;

    @NotNull(message = "The locality must be filled.")
    @Size(min = 3, max = 100)
    private final String locality;

    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}
