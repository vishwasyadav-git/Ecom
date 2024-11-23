package com.scaler.productservice1ecom.dtos.fakeStore;

import com.scaler.productservice1ecom.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreGetProductResponseDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

    public Product toProduct(){
        Product product1=new Product();
        product1.setId(this.getId());
        product1.setTitle(this.getTitle());
        product1.setDescription(this.getDescription());
        product1.setImageUrl(this.getImage());
        product1.setCategoryName(this.getCategory());
        product1.setPrice(this.getPrice());
        return product1;
    }
}
