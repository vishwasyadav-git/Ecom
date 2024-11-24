package com.scaler.productservice1ecom.repositories;

import com.scaler.productservice1ecom.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
   Product save(Product product);

    @Override
    void delete(Product entity);
}
