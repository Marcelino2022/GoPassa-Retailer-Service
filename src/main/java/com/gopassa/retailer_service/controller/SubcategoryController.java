package com.gopassa.retailer_service.controller;

import com.gopassa.retailer_service.application.dto.domainDTO.SubcategoryDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateSubcategoryDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateSubcategoyDTO;
import com.gopassa.retailer_service.application.services.SubcategoryService;
import com.gopassa.retailer_service.domain.entities.Subcategory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("subcategories")
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    @GetMapping
    public ResponseEntity<List<SubcategoryDTO>> findAll() {
        List<Subcategory> subcategories = subcategoryService.findAll();
        List<SubcategoryDTO> subcategoryDTOs = subcategories
                .stream()
                .map(SubcategoryDTO::create)
                .toList();
        return ResponseEntity.ok(subcategoryDTOs);
    }


    @PostMapping
    public ResponseEntity<SubcategoryDTO> create(@RequestBody CreateSubcategoryDTO createSubcategoryDTO) {
        Subcategory subcategory = subcategoryService.create(createSubcategoryDTO);
        return ResponseEntity.created(URI.create("/subcategories/" + subcategory.getId()))
                .body(SubcategoryDTO.create(subcategory));
    }

    @GetMapping("{id}")
    public ResponseEntity<SubcategoryDTO> findById(@PathVariable String id) {
        Subcategory subcategory = subcategoryService.findById(id);
        return ResponseEntity.ok(SubcategoryDTO.create(subcategory));
    }

    @PutMapping("{id}")
    public ResponseEntity<SubcategoryDTO> update(@PathVariable String id, @RequestBody UpdateSubcategoyDTO updateSubcategoyDTO) {
        Subcategory subcategory = subcategoryService.update(id, updateSubcategoyDTO);
        return ResponseEntity.ok(SubcategoryDTO.create(subcategory));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        subcategoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
