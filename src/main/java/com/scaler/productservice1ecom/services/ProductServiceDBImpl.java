package com.scaler.productservice1ecom.services;

import com.scaler.productservice1ecom.exceptions.ProductNotFoundException;
import com.scaler.productservice1ecom.models.Category;
import com.scaler.productservice1ecom.models.Product;
import com.scaler.productservice1ecom.repositories.CategoryRepository;
import com.scaler.productservice1ecom.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("DBproductService")
public class ProductServiceDBImpl implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceDBImpl(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public Product createProduct(Product product) {
        String categoryName=product.getCategory().getName();
        Optional<Category> category=
                categoryRepository.findByName(categoryName);
        Category toBePutInProduct=null;
        if(category.isEmpty()){
            Category saveToCategory=new Category();
            saveToCategory.setName(categoryName);
           toBePutInProduct= categoryRepository.save(saveToCategory);
        }else{
            toBePutInProduct=category.get();
        }
        product.setCategory(toBePutInProduct);

        Product savedProduct=productRepository.save(product);

        return savedProduct;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product partialUpdateProject(Long productId,Product product) throws ProductNotFoundException {
        Optional<Product> productToUpdateOptional=productRepository.findById(productId);
        if(productToUpdateOptional.isEmpty()){
            throw new ProductNotFoundException();
        }
        Product productToUpdate=productToUpdateOptional.get();
        if(product.getDescription()!=null){
            productToUpdate.setDescription(product.getDescription());
        }
        if(product.getPrice()!=null){
            productToUpdate.setPrice(product.getPrice());
        }
        if(product.getTitle()!=null){
            productToUpdate.setTitle(product.getTitle());
        }
        if(product.getCategory()!=null){
            Category tobePutInProduct=getCategoryToBeInProduct(product);
            productToUpdate.setCategory(tobePutInProduct);

        }
        return productRepository.save(productToUpdate);
    }
    private Category getCategoryToBeInProduct(Product product) {
        String categoryName = product.getCategory().getName();

        Optional<Category> category =
                categoryRepository.findByName(categoryName);
        Category toBePutInProduct = null;

        if (category.isEmpty()) {
            Category toSaveCategory = new Category();
            toSaveCategory.setName(categoryName);

            toBePutInProduct = toSaveCategory;
        } else {
            toBePutInProduct = category.get();
        }
        return toBePutInProduct;
    }


}
