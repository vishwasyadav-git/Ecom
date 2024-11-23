package com.scaler.productservice1ecom.dtos.fakeStore;

import com.scaler.productservice1ecom.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductRequestDto {
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

    public  static  FakeStoreCreateProductRequestDto fromProduct(Product product){
        FakeStoreCreateProductRequestDto fakeStoreCreateProductRequestDto=new FakeStoreCreateProductRequestDto();
        fakeStoreCreateProductRequestDto.title= product.getTitle();
        fakeStoreCreateProductRequestDto.description= product.getDescription();
        fakeStoreCreateProductRequestDto.category= product.getCategoryName();
        fakeStoreCreateProductRequestDto.price= product.getPrice();
        fakeStoreCreateProductRequestDto.image=product.getImageUrl();

        return  fakeStoreCreateProductRequestDto;
    }
}
