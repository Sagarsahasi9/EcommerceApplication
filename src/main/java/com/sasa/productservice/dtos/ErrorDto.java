package com.sasa.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {
    public String status;
    public String message;
}
