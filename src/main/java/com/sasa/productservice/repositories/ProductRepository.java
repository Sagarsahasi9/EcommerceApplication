package com.sasa.productservice.repositories;

import com.sasa.productservice.models.Category;
import com.sasa.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product product);


    List<Product> findAll();


    List<Product> findByCategory(Category category);

    List<Product> findByCategory_NameEquals(String CategoryName);

    //    @Query("select p from Product p where p.category.name = :categoryName")
//    List<Product> getProductsBasedOnCategoryNames(String categoryName);
//
//    @Query(value = "select * from product p join category c on p.category_id = c.id", nativeQuery = true)
//    List<Product> getProductsBasedOnCategoryNames2();
//
//    @Query(value = CustomQuery.GET_PRODUCTS_FROM_CATEGORY_NAME, nativeQuery = true)
//    List<Product> getProductsBasedOnCategoryNames3();
}
