package com.scaler.productservice1ecom.advices;

import com.scaler.productservice1ecom.dtos.ErrorResponseDto;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionsAdvices {
    public ErrorResponseDto handleRuntimeException(RuntimeException e){
        ErrorResponseDto dto=new ErrorResponseDto();
        dto.setStatus("Error");
        dto.setMessage(e.getMessage());
        return dto;

    }
    @ExceptionHandler(RuntimeException.class)
    public String handleException(){
        return "something went wrong in controller";
    }
}
