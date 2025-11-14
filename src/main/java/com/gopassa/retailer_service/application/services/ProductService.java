package com.gopassa.retailer_service.application.services;

import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateProductDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateProductDTO;
import com.gopassa.retailer_service.domain.entities.Product;
import com.gopassa.retailer_service.domain.entities.Retailer;
import com.gopassa.retailer_service.domain.entities.Subcategory;
import com.gopassa.retailer_service.domain.enums.DiscountCondition;
import com.gopassa.retailer_service.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final RetailerService retailerService;
    private final SubcategoryService subcategoryService;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public Product create(CreateProductDTO createProductDTO) {

        Retailer retailer = retailerService.findById(createProductDTO.getRetailerId());
        Subcategory subcategory = subcategoryService.findById(createProductDTO.getSubcategoryId());

        Product product = Product.builder()
                .description(createProductDTO.getDescription())
                .brand(createProductDTO.getBrand())
                .weight(createProductDTO.getWeight())
                .unitOfMeasure(createProductDTO.getUnitOfMeasure())
                .color(createProductDTO.getColor())
                .price(createProductDTO.getPrice())
                .quantity(createProductDTO.getQuantity())
                .barcode(createProductDTO.getBarcode())
                .sku(createProductDTO.getSku())
                .minStockLevel(createProductDTO.getMinStockLevel())
                .maxStockLevel(createProductDTO.getMaxStockLevel())
                .active(createProductDTO.getActive())
                .taxRate(createProductDTO.getTaxRate())
                .discountRate(createProductDTO.getDiscountRate())
                .discountCondition(convertToDiscountCondition(String.valueOf(createProductDTO.getDiscountCondition())))
                .expiryDate(createProductDTO.getExpiryDate())
                .retailer(retailer)
                .subcategory(subcategory)
                .build();
        return productRepository.save(product);
    }


    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(() ->
                new InvalidParameterException("Product not found: " + id )
        );
    }


    @Transactional
    public Product update(String id, UpdateProductDTO updateProductDTO) {

        Product product = findById(id);
        product.setDescription(updateProductDTO.getDescription());
        product.setBrand(updateProductDTO.getBrand());
        product.setWeight(updateProductDTO.getWeight());
        product.setUnitOfMeasure(updateProductDTO.getUnitOfMeasure());
        product.setColor(updateProductDTO.getColor());
        product.setPrice(updateProductDTO.getPrice());
        product.setQuantity(updateProductDTO.getQuantity());
        product.setBarcode(updateProductDTO.getBarcode());
        product.setSku(updateProductDTO.getSku());
        product.setMinStockLevel(updateProductDTO.getMinStockLevel());
        product.setMaxStockLevel(updateProductDTO.getMaxStockLevel());
        product.setActive(updateProductDTO.getActive());
        product.setTaxRate(updateProductDTO.getTaxRate());
        product.setDiscountRate(updateProductDTO.getDiscountRate());
        product.setDiscountCondition(convertToDiscountCondition(String.valueOf(updateProductDTO.getDiscountCondition())));
        product.setExpiryDate(updateProductDTO.getExpiryDate());

        return productRepository.save(product);
    }


    @Transactional
    public void delete(String id) {
        productRepository.deleteById(id);
    }


    private DiscountCondition convertToDiscountCondition(String discountCondition) {
        try {
            return DiscountCondition.valueOf(discountCondition.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidParameterException("Invalid discount condition: " + discountCondition);
        }
    }
}
