package com.scaler.productservice1ecom.services;

import com.scaler.productservice1ecom.dtos.FakeStoreCreateProductRequestDto;
import com.scaler.productservice1ecom.dtos.FakeStoreCreateProductResponseDto;
import com.scaler.productservice1ecom.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
//@Primary
public class ProductServiceFakeStoreImpl implements ProductService{

    private RestTemplate restTemplate;
    public ProductServiceFakeStoreImpl(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDto request=new FakeStoreCreateProductRequestDto();
        request.setCategory(product.getCategoryName());
        request.setImage(product.getImageUrl());
        request.setPrice(product.getPrice());
        request.setTitle(product.getTitle());
        request.setDescription(product.getDescription());

       FakeStoreCreateProductResponseDto  response=restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                request,
                FakeStoreCreateProductResponseDto.class
        );
       Product product1=new Product();
       product1.setId(response.getId());
       product1.setTitle(response.getTitle());
       product1.setDescription(response.getDescription());
       product1.setImageUrl(response.getImage());
       product1.setCategoryName(response.getCategory());
       product1.setPrice(response.getPrice());
        return product1;
    }
}
