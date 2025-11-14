package com.gopassa.retailer_service.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


import static jakarta.persistence.GenerationType.UUID;

@Builder
@Data
@Entity
@Table(name = "retailers")
@NoArgsConstructor
@AllArgsConstructor
public class Retailer {

    @Id
    @GeneratedValue(strategy = UUID)
    @Column(length = 36)
    private String id;

    @Column(name = "tenant_id", length = 36, nullable = false)
    private String tenantId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "acronym", length = 6)
    private String acronym;

    @Column(name = "email", unique = true, nullable = false ,length = 100)
    private String email;

    @Column(name = "mobile_number", unique = true, nullable = false, length = 20)
    private String mobileNumber;

    @Column(name = "phone_number", unique = true, nullable = true, length = 20)
    private String phoneNumber;

    @Column(name = "nif", unique = true, nullable = true, length = 14)
    private String nif;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Column(name = "posta_code", nullable = false, length = 20)
    private String postalCode;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "county", nullable = false, length = 100)
    private String country;

    @Column(name = "locality", nullable = false, length = 100)
    private String locality;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();


    @OneToMany(mappedBy = "retailer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;

    @OneToMany(mappedBy = "retailer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Section> sections;

    @OneToMany(mappedBy = "retailer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> categories;

    @OneToMany(mappedBy = "retailer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Device> gopassaDevices;
}
