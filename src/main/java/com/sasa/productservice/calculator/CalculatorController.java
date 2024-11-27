package com.sasa.productservice.calculator;

import org.springframework.stereotype.Controller;

@Controller
public class CalculatorController {
    private CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    public int add(int a, int b) {
        System.out.println("Some logic");
        System.out.println("Some logic");
        int result=calculatorService.sumFromService(a,b);
        System.out.println("Some logic");
        return result;
    }
}
