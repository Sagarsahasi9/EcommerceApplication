package com.sasa.productservice.services;

import com.sasa.productservice.ProductNotFoundException;
import com.sasa.productservice.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(Long id) throws ProductNotFoundException;

    public List<Product> getAllProducts();

    public  Product createProduct(String title, String description, Double price, String imageUrl, String categoryName);

    public Product partialUpdate(Long id,Product product) throws ProductNotFoundException;
}
