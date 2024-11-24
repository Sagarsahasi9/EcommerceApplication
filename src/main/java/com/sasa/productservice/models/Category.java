package com.sasa.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
