package com.sasa.productservice.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public Integer sumFromService(int a, int b) {
        System.out.println("Some logic");
        System.out.println("Some more logic");
        int result = a + b;
        System.out.println("Some logic after add");
        return result;
    }
}
