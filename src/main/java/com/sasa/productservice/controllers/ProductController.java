package com.sasa.productservice.controllers;

import com.sasa.productservice.dtos.ProductResponseDto;
import com.sasa.productservice.models.Product;
import com.sasa.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("product/{id}")
    public ProductResponseDto getProductById(@PathVariable("id") Long id) {

     Product product = productService.getProductById(id);
     return ProductResponseDto.from(product);

    }
    @GetMapping("/product")
    public String getAllProducts() {
       return "Hello Saga";
    }
    public void createProduct() {

    }
    public void deleteProduct() {

    }
    public void updateProduct() {

    }
}
