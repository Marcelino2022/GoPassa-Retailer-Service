package com.gopassa.retailer_service.application.services;

import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateCategoryDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateCategoryDTO;
import com.gopassa.retailer_service.domain.entities.Category;
import com.gopassa.retailer_service.domain.entities.Retailer;
import com.gopassa.retailer_service.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final RetailerService retailerService;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    @Transactional
    public Category create(CreateCategoryDTO createCategoryDTO) {

        Retailer retailer = retailerService.findById(createCategoryDTO.getRetailerId());

        Category category = Category
                .builder()
                .designation(createCategoryDTO.getDesignation())
                .retailer(retailer)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        categoryRepository.save(category);
        return category;
    }


    public Category findById(String id) {
        return categoryRepository.findById(id).orElse(null);
    }


    public Category update(String id, UpdateCategoryDTO updateCategoryDTO) {
        Category category = findById(id);
        category.setDesignation(updateCategoryDTO.getDesignation());
        return category;
    }

    public void deleteById(String id) {
        categoryRepository.deleteById(id);
    }


}
