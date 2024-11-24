package com.sasa.productservice.repositories;

import com.sasa.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product product);


    List<Product> findAll();
}
