package com.sasa.productservice.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
public class CalculatorControllerTest {

//    private CalculatorService calculatorService= Mockito.mock(CalculatorService.class);
//
//   private CalculatorController calculatorController=
//           new CalculatorController(calculatorService);

    @Mock
    private CalculatorService calculatorService;
   @Autowired
    private CalculatorController calculatorController;

   @Test
    public void testAddWhenTwoIntegersArePassed() {
       when(calculatorService.sumFromService(5,10)).thenReturn(15);
       int a=5;
       int b=10;
       int expectedResult=15;
       int result=calculatorController.add(a,b);

       Assertions.assertEquals(expectedResult,result);

   }
    @Test
    public void testAddWhenTwoIntegersArePassed2() {
        int a=5;
        int b=10;
        int result=calculatorController.add(a,b);

        Assertions.assertEquals(true,false);

    }

}
