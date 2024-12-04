package com.scaler.productservice1ecom.dtos.product;

import com.scaler.productservice1ecom.models.Category;
import com.scaler.productservice1ecom.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String image;


    public static GetProductDto from(Product product){
        GetProductDto getProductResponseDto=new GetProductDto();
        getProductResponseDto.setId(product.getId());
        getProductResponseDto.setDescription(product.getDescription());
        getProductResponseDto.setImage(product.getImageUrl());
        getProductResponseDto.setPrice(product.getPrice());
        getProductResponseDto.setTitle(product.getTitle());
        return getProductResponseDto;
    }
}
