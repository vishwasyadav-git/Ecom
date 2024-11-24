package com.scaler.productservice1ecom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product extends  BaseModel{
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    @ManyToOne
    private Category category;
}
