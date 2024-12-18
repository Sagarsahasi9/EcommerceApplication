package com.sasa.productservice.dtos;

import com.sasa.productservice.models.Category;
import com.sasa.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDto {
    //Attributes same as fakestore attribute
    private Long id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;

    public Product toProduct()
    {

        Product product = new Product();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setImageUrl(this.image);
        product.setPrice(Double.valueOf(this.price));

        Category category1 = new Category();
        category1.setName(this.category);
        product.setCategory(category1);
        return product;
    }
}




