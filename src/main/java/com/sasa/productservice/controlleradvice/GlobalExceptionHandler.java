package com.sasa.productservice.controlleradvice;

import com.sasa.productservice.ProductNotFoundException;
import com.sasa.productservice.dtos.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException exception){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(exception.getMessage());
        errorDto.setStatus("Failure");

        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto, HttpStatus.valueOf(404));
        return responseEntity;

    }
}
