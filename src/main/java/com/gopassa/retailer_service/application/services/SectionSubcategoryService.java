package com.gopassa.retailer_service.application.services;

import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateSectionSubcategoryDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateSectionSubcategoryDTO;
import com.gopassa.retailer_service.domain.entities.Section;
import com.gopassa.retailer_service.domain.entities.SectionSubcategory;
import com.gopassa.retailer_service.domain.entities.Subcategory;
import com.gopassa.retailer_service.infrastructure.validator.SectionSubcategoryValidator;
import com.gopassa.retailer_service.repository.SectionSubcategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SectionSubcategoryService {

    private final SectionSubcategoryRepository sectionSubcategoryRepository;
    private final SectionService sectionService;
    private final SubcategoryService subcategoryService;
    private final SectionSubcategoryValidator sectionSubcategoryValidator;

    public List<SectionSubcategory> findAll(){
        return sectionSubcategoryRepository.findAll();
    }


    @Transactional
    public SectionSubcategory create(CreateSectionSubcategoryDTO createSectionSubcategoryDTO){

        sectionSubcategoryValidator.validate(
                createSectionSubcategoryDTO.getSectionId(),
                createSectionSubcategoryDTO.getSubcategoryId()
        );

        Section section = sectionService.findById(createSectionSubcategoryDTO.getSectionId());
        Subcategory subcategory = subcategoryService.findById(createSectionSubcategoryDTO.getSubcategoryId());

        SectionSubcategory sectionSubcategory = SectionSubcategory.builder()
                .subcategory(subcategory)
                .section(section)
                .build();

        return sectionSubcategoryRepository.save(sectionSubcategory);

    }


    public SectionSubcategory findById(String id){
        return sectionSubcategoryRepository.findById(id).orElse(null);
    }


    @Transactional
    public SectionSubcategory update(String id, UpdateSectionSubcategoryDTO updateSectionSubcategoryDTO){

        sectionSubcategoryValidator.validate(
                updateSectionSubcategoryDTO.getSectionId(),
                updateSectionSubcategoryDTO.getSubcategoryId()
        );

        Section section = sectionService.findById(updateSectionSubcategoryDTO.getSectionId());
        Subcategory subcategory = subcategoryService.findById(updateSectionSubcategoryDTO.getSubcategoryId());
        SectionSubcategory sectionSubcategory = findById(id);

        sectionSubcategory.setSubcategory(subcategory);
        sectionSubcategory.setSection(section);

        return sectionSubcategory;
    }


    @Transactional
    public void delete(String id){
        sectionSubcategoryRepository.deleteById(id);
    }
}
