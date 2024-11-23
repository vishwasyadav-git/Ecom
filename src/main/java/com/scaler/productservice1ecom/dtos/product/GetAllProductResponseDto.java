package com.scaler.productservice1ecom.dtos.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class GetAllProductResponseDto {
    List<GetProductDto>products;
}
