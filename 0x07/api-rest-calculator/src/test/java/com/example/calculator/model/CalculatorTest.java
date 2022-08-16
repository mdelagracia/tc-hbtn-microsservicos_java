package com.example.calculator.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    static Calculator calculator;

    @BeforeAll
    public static void setup() {
       calculator = new Calculator();
    }

    @Test
    public void sumTest() {
       Double number1 = 2.0;
       Double number2 = 3.0;
       Double expectedResult = 5.0;
       Double result = calculator.sum(number1, number2);
        assertEquals(expectedResult, result);
    }

    @Test
    public void numbersNullSumTest() {
        Double number1 = 2.0;
        Double number2 = null;
        Exception exception = assertThrows(NullPointerException.class,
                ()->calculator.sum(number1,number2));
        assertEquals("Número 1 e número 2 são obrigatórios.", exception.getMessage());
    }

    @Test
    public void subTest() {
        Double number1 = 3.0;
        Double number2 = 2.0;
        Double expectedResult = 1.0;
        Double result = calculator.sub(number1, number2);
        assertEquals(expectedResult, result);
    }

    @Test
    void divideTest() {
        Double number1 = 6.0;
        Double number2 = 3.0;
        Double expectedResult = 2.0;
        Double result = calculator.divide(number1, number2);
        assertEquals(expectedResult, result);
    }

    @Test
    public void divisionByZeroTest() {
        Double number1 = 2.0;
        Double number2 = 0.0;
        Exception exception = assertThrows(ArithmeticException.class,
                ()->calculator.divide(number1,number2));
        assertEquals("Divisão por zero não é permitido.", exception.getMessage());
    }

    @Test
    public void factorialTest() {
        Integer factorial = 4;
        Integer expectedResult = 24;
        Integer result = calculator.factorial(factorial);
        assertEquals(expectedResult, result);
    }

    @Test
    void integerToBinaryTest() {
        Integer integer = 3;
        Integer expectedResult = 11;
        Integer result = calculator.integerToBinary(integer);
        assertEquals(expectedResult, result);
    }

    @Test
    void integerToHexadecimalTest() {
        Integer integer = 16;
        Integer expectedResult = 10;
        Integer result = Integer.valueOf(calculator.integerToHexadecimal(integer));
        assertEquals(expectedResult, result);
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate localDate1 = LocalDate.of(2022,8,2);
        LocalDate localDate2 = LocalDate.of(2022,8,29);
        Integer expectedResult = 27;
        Integer result = Integer.valueOf(calculator.calculeDayBetweenDate(localDate1, localDate2));
        assertEquals(expectedResult, result);
    }
}
