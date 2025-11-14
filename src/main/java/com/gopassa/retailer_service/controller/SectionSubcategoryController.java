package com.gopassa.retailer_service.controller;

import com.gopassa.retailer_service.application.dto.domainDTO.SectionSubcategoryDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateSectionSubcategoryDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateSectionSubcategoryDTO;
import com.gopassa.retailer_service.application.services.SectionSubcategoryService;
import com.gopassa.retailer_service.domain.entities.SectionSubcategory;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("section-subcategories")
@RequiredArgsConstructor
public class SectionSubcategoryController {

    public final SectionSubcategoryService sectionSubcategoryService;

    @GetMapping
    public ResponseEntity<List<SectionSubcategoryDTO>> findAll() {
        List<SectionSubcategory> sectionSubcategory = sectionSubcategoryService.findAll();
        List<SectionSubcategoryDTO> sectionSubcategoryDTOs = sectionSubcategory
                .stream()
                .map(SectionSubcategoryDTO::create)
                .toList();

        return ResponseEntity.ok(sectionSubcategoryDTOs);
    }


    @PostMapping
    public ResponseEntity<SectionSubcategoryDTO> create(@RequestBody @Valid CreateSectionSubcategoryDTO  createSectionSubcategoryDTO) {
        SectionSubcategory sectionSubcategory = sectionSubcategoryService.create(createSectionSubcategoryDTO);
        return ResponseEntity.created(URI.create("subsection-subcategories/" + sectionSubcategory.getId()))
                .body(SectionSubcategoryDTO.create(sectionSubcategory));
    }


    @GetMapping("{id}")
    public ResponseEntity<SectionSubcategoryDTO> findById(@PathVariable @Valid String id) {
        SectionSubcategory sectionSubcategory = sectionSubcategoryService.findById(id);
        return ResponseEntity.ok(SectionSubcategoryDTO.create(sectionSubcategory));
    }

    @PutMapping("{id}")
    public ResponseEntity<SectionSubcategoryDTO> update(@PathVariable @Valid String id,
                                                        @RequestBody @Valid UpdateSectionSubcategoryDTO updateSectionSubcategoryDTO) {

        SectionSubcategory sectionSubcategory = sectionSubcategoryService.update(id, updateSectionSubcategoryDTO);
        return ResponseEntity.ok(SectionSubcategoryDTO.create(sectionSubcategory));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable @Valid String id) {
        sectionSubcategoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
