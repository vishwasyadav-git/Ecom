package com.scaler.productservice1ecom.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private  Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String categoryName;
}
