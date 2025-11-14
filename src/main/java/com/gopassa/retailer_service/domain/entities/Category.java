package com.gopassa.retailer_service.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"retailer", "subcategories"})
@EqualsAndHashCode(exclude = {"retailer", "subcategories"})
public class Category {

    @Id
    @GeneratedValue(strategy = UUID)
    @Column(length = 36)
    private String id;

    @Column(name = "designation", nullable = false, length = 60)
    private String designation;

    @ManyToOne
    @JoinColumn(name = "retailer_id", nullable = false)
    @JsonBackReference
    private Retailer retailer;

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private List<Subcategory> subcategories;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
