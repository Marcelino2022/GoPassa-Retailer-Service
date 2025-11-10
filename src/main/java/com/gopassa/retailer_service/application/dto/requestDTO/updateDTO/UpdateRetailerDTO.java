package com.gopassa.retailer_service.application.dto.requestDTO.updateDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateRetailerDTO {

    @NotNull(message = "The name must be filled.")
    @Size(min = 2, max = 100)
    private final String name;

    @Size(min = 2, max = 6)
    private final String acronym;

    @NotNull(message = "The email must be filled.")
    private final String email;

    @Size(max = 20)
    private final String mobileNumber;

    @Size(max = 20)
    private final String phoneNumber;

    @Size(max = 20)
    private final String faxNumber;

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

    private final LocalDateTime updatedAt;
}
