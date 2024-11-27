package com.sasa.productservice.controllers;

import com.sasa.productservice.ProductNotFoundException;
import com.sasa.productservice.dtos.ProductResponseDto;
import com.sasa.productservice.models.Category;
import com.sasa.productservice.models.Product;
import com.sasa.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
//    @Mock
//    @Qualifier("productDbService")
//    private ProductService productService;
//    @Autowired
//    private ProductController productService;

@Qualifier("productDbService")
    private ProductService productService= Mockito.mock(ProductService.class);

    private ProductController productController=
           new ProductController(productService);

    @Test
    public void tstGetProductByIdReturnsProduct() throws ProductNotFoundException {
        Product dummyProduct = new Product();
        dummyProduct.setId(1L);
        dummyProduct.setTitle("abc");
        dummyProduct.setDescription("def");
        dummyProduct.setPrice(100.0);
        dummyProduct.setImageUrl("img/url.jpg");

        Category category = new Category();
        category.setId(1l);
        category.setName("electronics");
        dummyProduct.setCategory(category);

        when(productService.getProductById(1L)).
                thenReturn(dummyProduct);
        ProductResponseDto responseDto = productController.getProductById(1l);

        assertEquals(1L, responseDto.getId());
        assertEquals("abc", responseDto.getTitle());
        assertEquals("def", responseDto.getDescription());
    }

    @Test
    public void getProductByIdProductIsNull() throws ProductNotFoundException {
        when(productService.getProductById(1L)).thenReturn(null);
        ProductResponseDto responseDto = productController.getProductById(1l);
        assertNull(responseDto);
    }
}