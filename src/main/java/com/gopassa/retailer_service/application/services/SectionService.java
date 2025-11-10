package com.gopassa.retailer_service.application.services;

import com.gopassa.retailer_service.application.dto.referencesDTO.RetailerRefDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateSectionsDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateSectionDTO;
import com.gopassa.retailer_service.domain.entities.Retailer;
import com.gopassa.retailer_service.domain.entities.Section;
import com.gopassa.retailer_service.repository.SectionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionService {

    private final SectionRepository sectionRepository;
    private final RetailerService retailerService;

    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    @Transactional
    public Section create(CreateSectionsDTO createSectionsDTO) {

        Retailer retailer = retailerService.findById(createSectionsDTO.getRetailerId());

        Section section = Section.builder()
                .designation(createSectionsDTO.getDesignation())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .retailer(retailer)
                .build();

        return sectionRepository.save(section);
    }


    public Section findById(String id) {
        return sectionRepository.findById(id).orElse(null);
    }

    @Transactional
    public Section update(String id, UpdateSectionDTO updateSectionDTO) {

        Section section = findById(id);
        section.setDesignation(updateSectionDTO.getDesignation());
        section.setUpdatedAt(LocalDateTime.now());
        return section;
    }

    public void delete(String id) {
        sectionRepository.deleteById(id);

    }
}
