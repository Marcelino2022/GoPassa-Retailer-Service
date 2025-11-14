package com.gopassa.retailer_service.controller;

import com.gopassa.retailer_service.application.dto.domainDTO.RetailerDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateRetailerDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateRetailerDTO;
import com.gopassa.retailer_service.application.services.RetailerService;
import com.gopassa.retailer_service.domain.entities.Retailer;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("retailers")
@AllArgsConstructor
@SuppressWarnings("unused")
public class RetailerController {
    private final RetailerService retailerService;

    @GetMapping
    public ResponseEntity<List<RetailerDTO>> findAll() {
        List<Retailer> retailers = retailerService.findAll();
        List<RetailerDTO> retailerDTOs = retailers
                .stream()
                .map(RetailerDTO::create)
                .toList();
        return ResponseEntity.ok(retailerDTOs);
    }

    @PostMapping
    public ResponseEntity<RetailerDTO> create(@RequestBody @Valid CreateRetailerDTO createRetailerDTO) {
        Retailer retailer =  retailerService.create(createRetailerDTO);
        return ResponseEntity.created(URI.create("retailers/" + retailer.getId()))
                .body(RetailerDTO.create(retailer));
    }

    @GetMapping("{id}")
    public ResponseEntity<RetailerDTO> findById(@PathVariable @Valid String id){
        Retailer retailer = retailerService.findById(id);
        return  ResponseEntity.ok(RetailerDTO.create(retailer));
    }

    @PutMapping("{id}")
    public ResponseEntity<RetailerDTO> update(@PathVariable @Valid String id, @RequestBody @Valid UpdateRetailerDTO updateRetailerDTO) {
        Retailer retailer = retailerService.update(id,updateRetailerDTO);
        return  ResponseEntity.ok(RetailerDTO.create(retailer));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable @Valid String id){
        retailerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
