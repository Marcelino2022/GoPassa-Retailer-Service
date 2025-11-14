package com.gopassa.retailer_service.controller;

import com.gopassa.retailer_service.application.dto.domainDTO.RetailerDTO;
import com.gopassa.retailer_service.application.dto.domainDTO.SectionDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateSectionsDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateRetailerDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateSectionDTO;
import com.gopassa.retailer_service.application.services.SectionService;
import com.gopassa.retailer_service.domain.entities.Retailer;
import com.gopassa.retailer_service.domain.entities.Section;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("sections")
@AllArgsConstructor
public class SectionController {

    private final SectionService sectionService;

    @GetMapping
    public ResponseEntity<List<SectionDTO>> getAll() {
        List<Section> sections = sectionService.findAll();
        List<SectionDTO> sectionDTOs = sections
                .stream()
                .map(SectionDTO::create)
                .toList();

        return ResponseEntity.ok(sectionDTOs);
    }


    @PostMapping
    public ResponseEntity<SectionDTO> create(@RequestBody @Valid CreateSectionsDTO createSectionsDTO) {
        Section section =  sectionService.create(createSectionsDTO);
        return ResponseEntity.created(URI.create("sections/" + section.getId()))
                .body(SectionDTO.create(section));
    }

    @GetMapping("{id}")
    public ResponseEntity<SectionDTO> findById(@PathVariable @Valid String id){
        Section section = sectionService.findById(id);
        return  ResponseEntity.ok(SectionDTO.create(section));
    }


    @PutMapping("{id}")
    public ResponseEntity<SectionDTO> update(@PathVariable @Valid String id,
                                             @RequestBody @Valid UpdateSectionDTO updateSectionDTO) {
        Section section  = sectionService.update(id,updateSectionDTO);
        return  ResponseEntity.ok(SectionDTO.create(section));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable @Valid String id){
        sectionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
