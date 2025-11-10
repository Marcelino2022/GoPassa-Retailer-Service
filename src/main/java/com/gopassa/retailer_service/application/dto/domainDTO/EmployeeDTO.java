package com.gopassa.retailer_service.application.dto.domainDTO;

import com.gopassa.retailer_service.application.dto.referencesDTO.RetailerRefDTO;
import com.gopassa.retailer_service.domain.entities.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EmployeeDTO {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String mobileNumber;
    private final String position;
    private final String tenantId;
    private final String userId;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final RetailerRefDTO retailer;

    public static EmployeeDTO create(Employee employee) {
        return  new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getMobileNumber(),
                employee.getPosition(),
                employee.getTenantId(),
                employee.getUserId(),
                employee.getCreatedAt(),
                employee.getUpdatedAt(),
                RetailerRefDTO.create(employee.getRetailer())
        );
    }
}
