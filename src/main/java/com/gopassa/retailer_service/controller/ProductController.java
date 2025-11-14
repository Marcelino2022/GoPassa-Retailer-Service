package com.gopassa.retailer_service.controller;

import com.gopassa.retailer_service.application.dto.domainDTO.ProductDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateProductDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateProductDTO;
import com.gopassa.retailer_service.application.services.ProductService;
import com.gopassa.retailer_service.domain.entities.Product;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
@SuppressWarnings("unused")
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<Product> entities = productService.findAll();
        List<ProductDTO> productDTOS = entities
                .stream()
                .map(ProductDTO::create)
                .toList();
        return ResponseEntity.ok(productDTOS);
    }


    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody @Valid CreateProductDTO createProductDTO) {

        Product product = productService.create(createProductDTO);
        return ResponseEntity.created(URI.create("/products"  + product.getId()))
                .body(ProductDTO.create(product));
    }


    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable @Valid String id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok(ProductDTO.create(product));
    }


    @PutMapping("{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable @Valid String id, @RequestBody @Valid UpdateProductDTO updateProductDTO) {
        Product product = productService.update(id, updateProductDTO);
        return ResponseEntity.ok(ProductDTO.create(product));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<ProductDTO> delete(@PathVariable @Valid String id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
