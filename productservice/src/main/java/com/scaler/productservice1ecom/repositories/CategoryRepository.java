package com.scaler.productservice1ecom.repositories;

import com.scaler.productservice1ecom.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
   Optional<Category> findByName(String name);

    //    List<Category> findByIdGreaterThanAndNameGreaterThan(
//            Long id, String name);

    Category save(Category category);
}
