package com.sasa.productservice;

import com.sasa.productservice.models.Category;
import com.sasa.productservice.models.Product;
import com.sasa.productservice.repositories.CategoryRepository;
import com.sasa.productservice.repositories.ProductRepository;
import com.sasa.productservice.services.ProductService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {

    @Qualifier("productDbService")
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void getProductByCallingTwoMethods() {
        Optional<Category> category=categoryRepository.findByName("electronics");
        List<Product> product=productRepository.findByCategory(category.get());
        System.out.println(product);
    }
    @Test
    public void getProductByCallingOneMethods() {

        List<Product> product=productRepository.findByCategory_NameEquals("Books");
        System.out.println(product);
    }

    @Test
   // @Transactional
    public void getCategory(){
        Optional<Category> category=categoryRepository.findById(1L);
        System.out.println(category.get().getProducts());
    }
    @Test
    public void getCategory2(){
        Optional<Category> category=categoryRepository.findById(1L);
        System.out.println(category.get().getProducts());
    }
    @Test
    @Transactional
    public void nplus1Problem(){
        List<Category> categories=categoryRepository.findAll();
        for(Category category:categories){
            for(Product product:category.getProducts()){
                System.out.println(product.getTitle());
            }
        }
    }
}
