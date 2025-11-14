package com.gopassa.retailer_service.controller;

import com.gopassa.retailer_service.application.dto.domainDTO.SaleDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateSaleDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateSaleDTO;
import com.gopassa.retailer_service.application.services.SaleService;
import com.gopassa.retailer_service.domain.entities.Sale;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("sales")
@AllArgsConstructor
@SuppressWarnings("unused")
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<List<SaleDTO>> findAll() {
        List<Sale> sales = saleService.findAll();
        List<SaleDTO> saleDTOs = sales
                .stream()
                .map(SaleDTO::create)
                .toList();
        return ResponseEntity.ok(saleDTOs);
    }


    @PostMapping
    public ResponseEntity<SaleDTO> create(@RequestBody CreateSaleDTO createSaleDTO) {
        Sale sale = saleService.create(createSaleDTO);
        return ResponseEntity.created(URI.create("/sales/" + sale.getId()))
                .body(SaleDTO.create(sale));
    }


    @GetMapping("{id}")
    public ResponseEntity<SaleDTO> findById(@PathVariable String id) {
        Sale sale = saleService.findById(id);
        return ResponseEntity.ok(SaleDTO.create(sale));
    }

    @PutMapping("{id}")
    public ResponseEntity<SaleDTO> update(@PathVariable String id, @RequestBody UpdateSaleDTO updateSaleDTO) {
        Sale sale = saleService.update(id,updateSaleDTO);
        return ResponseEntity.ok(SaleDTO.create(sale));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        saleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
