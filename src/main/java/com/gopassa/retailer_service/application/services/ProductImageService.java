package com.gopassa.retailer_service.application.services;

import com.gopassa.retailer_service.application.dto.requestDTO.SaveProductImageDTO;
import com.gopassa.retailer_service.domain.entities.Product;
import com.gopassa.retailer_service.domain.entities.ProductImage;
import com.gopassa.retailer_service.repository.ProductImageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImageService {

    private final ProductImageRepository productImageRepository;
    private final ProductService productService;

    public List<ProductImage> findAll(){
        return productImageRepository.findAll();
    }


    @Transactional
    public ProductImage create(SaveProductImageDTO saveProductImageDTO){

        Product  product = productService.findById(saveProductImageDTO.getProductId());

        ProductImage productImage = ProductImage
                .builder()
                .imageUrl(saveProductImageDTO.getImageUrl())
                .isPrimary(saveProductImageDTO.getIsPrimary())
                .angle(saveProductImageDTO.getAngle())
                .lightingCondition(saveProductImageDTO.getLightingCondition())
                .resolution(saveProductImageDTO.getResolution())
                .source(saveProductImageDTO.getSource())
                .product(product)
                .build();

        productImageRepository.save(productImage);
        return productImage;
    }


    public ProductImage findById(String id) {
        return productImageRepository.findById(id).orElse(null);
    }

    @Transactional
    public ProductImage update(String id, SaveProductImageDTO saveProductImageDTO){

        Product  product = productService.findById(saveProductImageDTO.getProductId());
        ProductImage productImage = findById(id);

        productImage.setImageUrl(saveProductImageDTO.getImageUrl());
        productImage.setIsPrimary(saveProductImageDTO.getIsPrimary());
        productImage.setAngle(saveProductImageDTO.getAngle());
        productImage.setLightingCondition(saveProductImageDTO.getLightingCondition());
        productImage.setResolution(saveProductImageDTO.getResolution());
        productImage.setSource(saveProductImageDTO.getSource());
        productImage.setProduct(product);

        return productImage;
    }


    public void delete(String id){
        productImageRepository.deleteById(id);
    }
}
