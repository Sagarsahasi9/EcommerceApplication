package com.sasa.productservice.controllers;

import com.sasa.productservice.ProductNotFoundException;
import com.sasa.productservice.dtos.ProductRequestDto;
import com.sasa.productservice.dtos.ProductResponseDto;
import com.sasa.productservice.models.Product;
import com.sasa.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("product/{id}")
    public ProductResponseDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product product = productService.getProductById(id);
        return ProductResponseDto.from(product);

    }
    @GetMapping("/product")
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDto> responseDtos = new ArrayList<>();

        for (Product product : products)
        {
            responseDtos.add(ProductResponseDto.from(product));

        }
       return responseDtos;
    }
    @PostMapping("/product")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        Product product = productService.createProduct(
                productRequestDto.getTitle(),
                productRequestDto.getDescription(),
                productRequestDto.getPrice(),
                productRequestDto.getImageUrl(),
                productRequestDto.getCategoryName()
        );

        return ProductResponseDto.from(product);
    }

    public void deleteProduct() {

    }
    public void updateProduct() {

    }
}
