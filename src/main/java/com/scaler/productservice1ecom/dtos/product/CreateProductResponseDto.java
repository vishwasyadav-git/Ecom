package com.scaler.productservice1ecom.dtos.product;

import com.scaler.productservice1ecom.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductResponseDto {
    private  Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String categoryName;

    public  static CreateProductResponseDto fromProduct(Product product){
        CreateProductResponseDto responseDto=new CreateProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
        responseDto.setTitle(product.getTitle());
        responseDto.setImageUrl(product.getImageUrl());
        responseDto.setCategoryName(product.getCategoryName());
        return responseDto;
    }
}
