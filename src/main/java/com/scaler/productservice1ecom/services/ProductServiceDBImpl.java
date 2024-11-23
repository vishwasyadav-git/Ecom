package com.scaler.productservice1ecom.services;

import com.scaler.productservice1ecom.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DBproductService")
public class ProductServiceDBImpl implements ProductService {
    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public Product partialUpdateProject(Long productId,Product product) {
        return null;
    }


}
