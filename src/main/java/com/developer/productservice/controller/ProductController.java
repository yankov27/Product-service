package com.developer.productservice.controller;

import com.developer.productservice.entity.ProductEntity;
import com.developer.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor

public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity createProduct(@RequestBody ProductEntity productEntity) {
        return productService.saveProduct(productEntity);
    }

    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<ProductEntity> findProductById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity updateProduct(@RequestBody ProductEntity productEntity) {
        return productService.updateProduct(productEntity);
    }

    @DeleteMapping ("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}
