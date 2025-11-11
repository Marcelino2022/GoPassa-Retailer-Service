package com.gopassa.retailer_service.application.services;

import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateSubcategoryDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateSubcategoyDTO;
import com.gopassa.retailer_service.domain.entities.Category;
import com.gopassa.retailer_service.domain.entities.Subcategory;
import com.gopassa.retailer_service.repository.SubcategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;
    private final CategoryService categoryService;

    public List<Subcategory> findAll() {
        return subcategoryRepository.findAll();
    }

    @Transactional
    public Subcategory create(CreateSubcategoryDTO createSubcategoryDTO) {

        Category category = categoryService.findById(createSubcategoryDTO.getCategoryId());

        System.out.println(category);
        System.out.println(createSubcategoryDTO.getCategoryId());

        Subcategory subcategory = Subcategory.builder()
                .designation(createSubcategoryDTO.getDesignation())
                .category(category)
                .build();
        subcategoryRepository.save(subcategory);
        return subcategory;
    }

    public Subcategory findById(String id) {
        return subcategoryRepository.findById(id).orElse(null);
    }

    @Transactional
    public Subcategory update(String id, UpdateSubcategoyDTO updateSubcategoyDTO) {
        Subcategory subcategory = findById(id);
        subcategory.setDesignation(updateSubcategoyDTO.getDesignation());
        return subcategory;
    }

    @Transactional
    public void delete(String id) {
        subcategoryRepository.deleteById(id);
    }
}
