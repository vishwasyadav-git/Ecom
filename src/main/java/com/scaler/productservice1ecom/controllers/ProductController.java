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

    private final WebClient webClient;
//@Autowired
//private  String name;
    public  ProductController(@Qualifier("fakeStoreProductService") ProductService productService, WebClient webClient){
        this.productService=productService;
        this.webClient = webClient;
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
        // Update product using WebClient
        Product product = webClient.patch()
                .uri("/products/{id}", productId)
                .bodyValue(productDto.toProduct())
                .retrieve()
                .bodyToMono(Product.class)
                .onErrorResume(ex -> {
                    // Log and return a fallback product
                    System.err.println("API error: " + ex.getMessage());
                    return Mono.just(new Product());
                })
                .block();

        PatchProductResponseDto response = new PatchProductResponseDto();
        response.setProduct(GetProductDto.from(product));
        return response;
//        Product product= productService.partialUpdateProject(
//                productId,
//                productDto.toProduct()
//        );
//        PatchProductResponseDto response=new PatchProductResponseDto();
//        response.setProduct(GetProductDto.from(product));
//        return response;
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
