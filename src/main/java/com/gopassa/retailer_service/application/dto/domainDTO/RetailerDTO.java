package com.gopassa.retailer_service.application.dto.domainDTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gopassa.retailer_service.domain.entities.Employee;
import com.gopassa.retailer_service.domain.entities.Retailer;

import com.gopassa.retailer_service.domain.entities.Section;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Data
public class RetailerDTO {

    private final String id;
    private final String tenantId;
    private final String name;
    private final String acronym;
    private final String email;
    private final String mobileNumber;
    private final String phoneNumber;
    private final String nif;
    private final String address;
    private final String postalCode;
    private final String city;
    private final String country;
    private final String locality;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final Set<Employee> employees;
    private final Set<Section> sections;



    public static RetailerDTO create(Retailer retailer){

        return new RetailerDTO(
                retailer.getId(),
                retailer.getTenantId(),
                retailer.getName(),
                retailer.getAcronym(),
                retailer.getEmail(),
                retailer.getMobileNumber(),
                retailer.getPhoneNumber(),
                retailer.getNif(),
                retailer.getAddress(),
                retailer.getPostalCode(),
                retailer.getCity(),
                retailer.getCountry(),
                retailer.getLocality(),
                retailer.getCreatedAt(),
                retailer.getUpdatedAt(),
                Optional
                        .ofNullable(retailer.getEmployees())
                        .orElse(List.of())
                        .stream()
                        .flatMap(emp -> emp.getRetailer().getEmployees().stream())
                        .collect(toSet()),
                Optional
                        .ofNullable(retailer.getEmployees())
                        .orElse(List.of())
                        .stream()
                        .flatMap(emp -> emp.getRetailer().getSections().stream())
                        .collect(toSet())
        );
    }
}
