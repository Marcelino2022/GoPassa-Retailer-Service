package com.gopassa.retailer_service.repository;

import com.gopassa.retailer_service.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
