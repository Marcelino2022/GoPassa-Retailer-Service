package com.gopassa.retailer_service.domain.validator;

import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateSectionSubcategoryDTO;
import com.gopassa.retailer_service.application.dto.validateDTO.ValidateSectionSubcategoryDTO;
import com.gopassa.retailer_service.domain.entities.SectionSubcategory;
import com.gopassa.retailer_service.domain.exceptions.DuplicatedRecord;
import com.gopassa.retailer_service.repository.SectionSubcategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SectionSubcategoryValidator {

    private final SectionSubcategoryRepository sectionSubcategoryRepository;

    public void validate(String sectionId, String subcategoryId){
        if(sectionSubcategoryExists(sectionId, subcategoryId)){
            throw new DuplicatedRecord("Section Subcategory already exists");
        }
    }

    private boolean sectionSubcategoryExists(String sectionId, String subcategoryId){
        Optional<SectionSubcategory> sectionSubcategoryFound = sectionSubcategoryRepository
                .findBySectionIdAndSubcategoryId(sectionId , subcategoryId);

        return sectionSubcategoryFound.isPresent();
    }
}
