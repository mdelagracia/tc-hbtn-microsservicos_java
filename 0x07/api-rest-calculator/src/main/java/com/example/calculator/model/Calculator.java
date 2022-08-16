package com.example.calculator.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Calculator {

    public Double sum(Double number1, Double number2) {
        try {
            return number1 + number2;
        } catch (NullPointerException e) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
    }

    public Double sub(Double number1, Double number2) {
        try {
            return number1 - number2;
        } catch (NullPointerException e) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
    }

    public Double divide(Double number1, Double number2) {
        try {
            return (double) (number1.intValue() / number2.intValue());
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Divisão por zero não é permitido.");
        } catch (NullPointerException ex) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
    }

    public Integer factorial(Integer factorial) {
        try {
            int fatorial = 1;
            for (int i = 1; i < factorial + 1; i++) {
                fatorial *= i;
            }
            return fatorial;
        } catch (NullPointerException e) {
            throw new NullPointerException("Número é obrigatório.");
        }
    }

    public Integer integerToBinary(Integer integer) {
        try {
           return Integer.valueOf(Integer.toBinaryString(integer));
        } catch (NullPointerException e) {
            throw new NullPointerException("Número é obrigatório.");
        }
    }

    public String integerToHexadecimal(Integer integer) {
        try {
            return Integer.toHexString(integer);
        } catch (NullPointerException e) {
            throw new NullPointerException("Número é obrigatório.");
        }
    }

    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        try {
            long between = ChronoUnit.DAYS.between(date1, date2);
            return Math.toIntExact(between);
        } catch (NullPointerException e) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
    }
}


