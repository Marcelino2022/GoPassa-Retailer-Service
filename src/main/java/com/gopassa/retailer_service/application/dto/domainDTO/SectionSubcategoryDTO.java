package com.gopassa.retailer_service.application.dto.domainDTO;
import com.gopassa.retailer_service.application.dto.referencesDTO.SectionRefDTO;
import com.gopassa.retailer_service.application.dto.referencesDTO.SubcategoryRefDTO;
import com.gopassa.retailer_service.domain.entities.SectionSubcategory;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SectionSubcategoryDTO {

    private final String id;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final SectionRefDTO Section;
    private final SubcategoryRefDTO subcategory;

    public static SectionSubcategoryDTO create(SectionSubcategory ss) {
        return new SectionSubcategoryDTO(
                ss.getId(),
                ss.getCreatedAt(),
                ss.getUpdatedAt(),
                SectionRefDTO.create(ss.getSection()),
                SubcategoryRefDTO.create(ss.getSubcategory())
        );
    }
}
