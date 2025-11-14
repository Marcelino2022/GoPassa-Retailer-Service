package com.gopassa.retailer_service.application.services;

import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateSaleDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateSaleDTO;
import com.gopassa.retailer_service.domain.entities.Retailer;
import com.gopassa.retailer_service.domain.entities.Sale;
import com.gopassa.retailer_service.domain.enums.SaleStatus;
import com.gopassa.retailer_service.repository.SaleRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;
    private final RetailerService retailerService;

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Transactional
    public Sale create(CreateSaleDTO createSaleDTO) {
        Retailer retailer = retailerService.findById(createSaleDTO.getRetailerId());
        Sale sale = Sale.builder()
                .totalAmount(createSaleDTO.getTotalAmount())
                .status(convertSaleStatus(createSaleDTO.getStatus()))
                .purchaseId(createSaleDTO.getPurchaseId())
                .retailer(retailer)
                .build();

        saleRepository.save(sale);
        return sale;
    }


    public Sale  findById(String id) {
        return saleRepository.findById(id).orElse(null);
    }


    @Transactional
    public Sale update(String id,UpdateSaleDTO updateSaleDTO) {
        Sale sale = findById(id);

        sale.setStatus(convertSaleStatus(updateSaleDTO.getStatus()));
        return sale;
    }


    @Transactional
    public void delete(String id) {
        saleRepository.deleteById(id);
    }


    private SaleStatus convertSaleStatus(String saleStatusStr) {
        try {
            if (saleStatusStr.isEmpty()) {
                return SaleStatus.IN_PROGRESS;
            }
            return SaleStatus.valueOf(saleStatusStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid saleStatus " + saleStatusStr);
        }
    }
}
