package com.gopassa.retailer_service.controller;

import com.gopassa.retailer_service.application.dto.domainDTO.CategoryDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateCategoryDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateCategoryDTO;
import com.gopassa.retailer_service.application.services.CategoryService;
import com.gopassa.retailer_service.domain.entities.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<Category> categories = categoryService.findAll();
        List<CategoryDTO> categoryDTOS = categories
                .stream()
                .map(CategoryDTO::create)
                .toList();

        return ResponseEntity.ok().body(categoryDTOS);
    }


    @PostMapping
    public ResponseEntity<CategoryDTO> create(@RequestBody CreateCategoryDTO  createCategoryDTO) {

        Category category = categoryService.create(createCategoryDTO);
        return ResponseEntity.created(URI.create("/categories/" + category.getId()))
                .body(CategoryDTO.create(category));
    }


    @GetMapping("{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable String id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok().body(CategoryDTO.create(category));
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable("id") String id,  @RequestBody UpdateCategoryDTO updateCategoryDTO) {
        Category category = categoryService.update(id, updateCategoryDTO);
        return ResponseEntity.ok().body(CategoryDTO.create(category));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CategoryDTO> delete(@PathVariable String id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
