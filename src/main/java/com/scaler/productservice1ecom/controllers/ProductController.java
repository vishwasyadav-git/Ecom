package com.scaler.productservice1ecom.controllers;

import com.scaler.productservice1ecom.dtos.CreateProductRequestDto;
import com.scaler.productservice1ecom.dtos.CreateProductResponseDto;
import com.scaler.productservice1ecom.models.Product;
import com.scaler.productservice1ecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
//    @Value("${productService}")
//    private String productServiceType;
    private ProductService productService;
//@Autowired
//private  String name;
    public  ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService=productService;
    }
    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        Product product= productService.createProduct(
                createProductRequestDto.toProduct()
        );

        return CreateProductResponseDto.fromProduct(
                product
        );

       // return "This product is priced at " + createProductRequestDto.getPrice();
    }

    @GetMapping("/")
    public  void getAllProducts(){

    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable Long id){
        return "Here is your product "+ id;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(){

    }
    @PatchMapping
public  void  updateProduct(){

}
@PutMapping
    public  void  replaceProduct(){

    }
    //Generic Custom mapping
//    @RequestMapping(name = "Vishwas",value = "/")
//    public String sampleTestForgeneric(){
//        return "TestedCustom Vishwas Request from postman";
//    }
}
