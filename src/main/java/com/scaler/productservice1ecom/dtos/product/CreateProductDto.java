package com.scaler.productservice1ecom.dtos.product;

import com.scaler.productservice1ecom.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

    public static CreateProductDto from(Product product){
        CreateProductDto responseDto=new CreateProductDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setCategory(product.getCategoryName());
        responseDto.setImage(product.getImageUrl());
        responseDto.setPrice(product.getPrice());
        return responseDto;
    }
    public Product toProduct(){
        Product product=new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.image);
        product.setCategoryName(this.category);
        return product;
    }
}
