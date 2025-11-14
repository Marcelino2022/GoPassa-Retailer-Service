package com.gopassa.retailer_service.controller;

import com.gopassa.retailer_service.application.dto.domainDTO.ProductImageDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.SaveProductImageDTO;
import com.gopassa.retailer_service.application.services.ProductImageService;
import com.gopassa.retailer_service.domain.entities.ProductImage;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("product-images")
@AllArgsConstructor
@SuppressWarnings("unused")
public class ProductImageController {

    private final ProductImageService productImageService;

    @GetMapping
    public ResponseEntity<List<ProductImageDTO>> getProductImages(){
        List<ProductImage> productImages = productImageService.findAll();
        List<ProductImageDTO> productImageDTOS = productImages
                .stream()
                .map(ProductImageDTO::create)
                .toList();

        return ResponseEntity.ok(productImageDTOS);
    }


    @PostMapping
    public ResponseEntity<ProductImageDTO> create(@RequestBody SaveProductImageDTO  saveProductImageDTO){
        ProductImage productImage = productImageService.create(saveProductImageDTO);
        return ResponseEntity.created(URI.create("/product-images" + productImage.getId()))
                .body(ProductImageDTO.create(productImage));
    }


    @GetMapping("{id}")
    public ResponseEntity<ProductImageDTO> findById(@PathVariable String id){
        ProductImage productImage = productImageService.findById(id);
        return ResponseEntity.ok(ProductImageDTO.create(productImage));
    }


    @PutMapping("{id}")
    public ResponseEntity<ProductImageDTO> update(@PathVariable String id, @RequestBody SaveProductImageDTO saveProductImageDTO){
        ProductImage productImage = productImageService.update(id, saveProductImageDTO);
        return ResponseEntity.ok(ProductImageDTO.create(productImage));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<ProductImageDTO> delete(@PathVariable String id){
        productImageService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
