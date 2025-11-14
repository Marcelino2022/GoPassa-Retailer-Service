package com.gopassa.retailer_service.application.services;

import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateRetailerDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateRetailerDTO;
import com.gopassa.retailer_service.domain.entities.Retailer;
import com.gopassa.retailer_service.repository.RetailerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RetailerService {

    private final RetailerRepository retailerRepository;

    public List<Retailer> findAll(){
        return retailerRepository.findAll();
    }

    @Transactional
    public Retailer create(CreateRetailerDTO createRetailerDTO){

        Retailer retailer = Retailer.builder()
                .tenantId(createRetailerDTO.getTenantId())
                .name(createRetailerDTO.getName())
                .acronym(createRetailerDTO.getAcronym())
                .email(createRetailerDTO.getEmail())
                .mobileNumber(createRetailerDTO.getMobileNumber())
                .phoneNumber(createRetailerDTO.getPhoneNumber())
                .nif(createRetailerDTO.getNif())
                .address(createRetailerDTO.getAddress())
                .postalCode(createRetailerDTO.getPostalCode())
                .city(createRetailerDTO.getCity())
                .country(createRetailerDTO.getCountry())
                .locality(createRetailerDTO.getLocality())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return retailerRepository.save(retailer);
    }


    public Retailer findById(String id){
        return retailerRepository.findById(id).orElseThrow( ()->
                new InvalidParameterException("Retailer not found: " + id ));
    }

    @Transactional
    public Retailer update(String id, UpdateRetailerDTO updateRetailerDTO){

        Retailer retailer = findById(id);

        retailer.setName(updateRetailerDTO.getName());
        retailer.setAcronym(updateRetailerDTO.getAcronym());
        retailer.setEmail(updateRetailerDTO.getEmail());
        retailer.setMobileNumber(updateRetailerDTO.getMobileNumber());
        retailer.setNif(updateRetailerDTO.getNif());
        retailer.setAddress(updateRetailerDTO.getAddress());
        retailer.setPostalCode(updateRetailerDTO.getPostalCode());
        retailer.setCity(updateRetailerDTO.getCity());
        retailer.setCountry(updateRetailerDTO.getCountry());
        retailer.setLocality(updateRetailerDTO.getLocality());
        retailer.setUpdatedAt(LocalDateTime.now());

        return retailer;
    }

    @Transactional
    public void delete(String id){
        retailerRepository.deleteById(id);
    }
}
