package com.scaler.productservice1ecom.services;

import com.scaler.productservice1ecom.exceptions.ProductNotFoundException;
import com.scaler.productservice1ecom.models.Product;

import java.awt.*;
import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProduct();

    Product partialUpdateProject(Long productId,Product product) throws ProductNotFoundException;
}
