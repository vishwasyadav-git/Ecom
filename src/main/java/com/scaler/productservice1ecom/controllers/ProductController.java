package com.scaler.productservice1ecom.controllers;

import com.scaler.productservice1ecom.dtos.product.*;
import com.scaler.productservice1ecom.models.Product;
import com.scaler.productservice1ecom.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

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
    public GetAllProductResponseDto getAllProducts(){
        List<Product> products=productService.getAllProduct();
        GetAllProductResponseDto response=new GetAllProductResponseDto();
        List<GetProductDto> getProductResponseDtos=new ArrayList<>();
        for(Product product:products){
            getProductResponseDtos.add(GetProductDto.from(product));

        }
        response.setProducts(getProductResponseDtos);
        return response;
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable Long id){
        return "Here is your product "+ id;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(){

    }
    @PatchMapping("/{id}")
    public  PatchProductResponseDto  updateProduct(
            @PathVariable("id") Long productId,
            @RequestBody CreateProductDto productDto
            ){

        Product product= productService.partialUpdateProject(
                productId,
                productDto.toProduct()
        );
        PatchProductResponseDto response=new PatchProductResponseDto();
        response.setProduct(GetProductDto.from(product));
        return response;
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
