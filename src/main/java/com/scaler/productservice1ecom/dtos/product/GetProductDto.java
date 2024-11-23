package com.scaler.productservice1ecom.dtos.product;

import com.scaler.productservice1ecom.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

    public static GetProductDto from(Product product){
        GetProductDto getProductResponseDto=new GetProductDto();
        getProductResponseDto.setId(product.getId());
        getProductResponseDto.setDescription(product.getDescription());
        getProductResponseDto.setCategory(product.getCategoryName());
        getProductResponseDto.setImage(product.getImageUrl());
        getProductResponseDto.setPrice(product.getPrice());
        return getProductResponseDto;
    }
}
