package com.scaler.productservice1ecom.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Category extends BaseModel{
    @Column(nullable = false, unique = true)
    private  String name;
    @Basic(fetch = FetchType.LAZY)
    private String description;
    @OneToMany
    private List<Product> products;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> featuredproducts;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private List<Product> allProducts;
    @OneToOne(cascade = {})
    private Subcategory subcategories;
   // private int countOfProduct;
}
