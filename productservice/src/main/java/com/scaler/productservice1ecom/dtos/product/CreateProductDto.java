package com.scaler.productservice1ecom.dtos.product;

import com.scaler.productservice1ecom.models.Category;
import com.scaler.productservice1ecom.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
public class CreateProductDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String image;
    private String categoryName;

    public static CreateProductDto from(Product product){
        CreateProductDto responseDto=new CreateProductDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getTitle());
        responseDto.setDescription(product.getDescription());
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
        Category category=new Category();
        category.setName(categoryName);
        product.setCategory(category);
        return product;
    }
}
