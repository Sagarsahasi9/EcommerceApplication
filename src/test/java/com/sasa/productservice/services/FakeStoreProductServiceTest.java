package com.sasa.productservice.services;

import com.sasa.productservice.ProductNotFoundException;
import com.sasa.productservice.dtos.FakeStoreProductRequestDto;
import com.sasa.productservice.dtos.FakeStoreProductResponseDto;
import com.sasa.productservice.models.Product;
import jdk.jfr.Category;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class FakeStoreProductServiceTest {

    RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

    FakeStoreProductService fakeStoreProductService = new FakeStoreProductService(restTemplate);

    @Test
    public void testGetProductByIdApiReturnsCorrectResponse() throws ProductNotFoundException {
        FakeStoreProductResponseDto dummyResponse = new FakeStoreProductResponseDto();
         dummyResponse.setId(1L);
         dummyResponse.setTitle("Title");
         dummyResponse.setDescription("Description");
         dummyResponse.setPrice("100");
         dummyResponse.setCategory("Category");
         dummyResponse.setImage("Image/url");

         when(restTemplate.getForObject("https://fakestoreapi.com/products/1",
                 FakeStoreProductResponseDto.class)).thenReturn(dummyResponse);

          Product product= fakeStoreProductService.getProductById(1L);

          assertEquals(1L, product.getId());
          assertEquals("Title", product.getTitle());
    }

    @Test
    public void testGetProductByIdApiResponseIsNull() throws ProductNotFoundException {
        when(restTemplate.getForObject(
                "https://fakestoreapi.com/products/1",
                FakeStoreProductResponseDto.class
        )).thenReturn(null);

        assertThrows(ProductNotFoundException.class,
                () -> fakeStoreProductService.getProductById(1L));
    }

    @Test
    public void testCreateProduct(){
    FakeStoreProductResponseDto dummyResponse = new FakeStoreProductResponseDto();
         dummyResponse.setId(1L);
         dummyResponse.setTitle("Title");
         dummyResponse.setDescription("Description");
         dummyResponse.setPrice("100");
         dummyResponse.setCategory("Category");
         dummyResponse.setImage("Image/url");

         when(restTemplate.postForObject(eq("https://fakestoreapi.com/products"),
                 any(),
                 eq(FakeStoreProductResponseDto.class)
         )).thenReturn(
                 dummyResponse);

         Product product= fakeStoreProductService.createProduct("Title","Description",100.0,
                 "Image/url","Category");
        verify(restTemplate,  times(1))
                .postForObject(
                        eq("https://fakestoreapi.com/products"),
                        any(),
                        eq(FakeStoreProductResponseDto.class)
                );
}}