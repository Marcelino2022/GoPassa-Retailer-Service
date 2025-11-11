package com.gopassa.retailer_service.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.UUID;

@Data
@Builder
@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = UUID)
    @Column(unique = true, nullable = false, length = 36)
    private String id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name="last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false, length = 60)
    private String email;

    @Column(name = "mobile_number", unique = true, nullable = false, length = 20)
    private String mobileNumber;

    @Column(name = "position", nullable = false, length = 30)
    private String position;

    @Column(name = "tenant_id", nullable = false, length = 36)
    private String tenantId;

    @Column(name = "user_id", unique = true, nullable = false, length = 36)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "retailer_id", nullable = false)
    @JsonBackReference
    private Retailer retailer;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
