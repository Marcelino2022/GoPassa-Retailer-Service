package com.gopassa.retailer_service.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.UUID;

@Builder
@Data
@Entity
@Table(name = "sections")
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = UUID)
    @Column(length = 36)
    private String id;

    @Column(name = "designation", nullable = false, unique = true)
    private String designation;

    @ManyToOne
    @JoinColumn(name = "retailer_id")
    @JsonBackReference
    private Retailer retailer;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
