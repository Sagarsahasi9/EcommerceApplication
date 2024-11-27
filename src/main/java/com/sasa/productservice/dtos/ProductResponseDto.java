package com.sasa.productservice.dtos;

import com.sasa.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String categoryName;

    public static ProductResponseDto from(Product product) {
        if(product == null) return null;

        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageUrl());
        responseDto.setTitle(product.getTitle());
        responseDto.setCategoryName(product.getCategory().getName());


        return responseDto;
    }
}
