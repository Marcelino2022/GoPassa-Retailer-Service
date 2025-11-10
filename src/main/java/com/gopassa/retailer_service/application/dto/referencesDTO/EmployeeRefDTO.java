package com.gopassa.retailer_service.application.dto.referencesDTO;

import lombok.Data;

@Data
public class EmployeeRefDTO {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String mobileNumber;
    private final String position;
}
