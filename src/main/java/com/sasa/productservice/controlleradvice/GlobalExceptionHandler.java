package com.sasa.productservice.controlleradvice;

import com.sasa.productservice.ProductNotFoundException;
import com.sasa.productservice.dtos.ErrorDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ErrorDto handleNullPointerException(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("somthing went wrong");
        errorDto.setStatus("Failure");
        return errorDto;
    }

    @ExceptionHandler
    public ErrorDto handleProductNotFoundException(ProductNotFoundException exception){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(exception.getMessage());
        errorDto.setStatus("Failure");
        return errorDto;

    }
}
