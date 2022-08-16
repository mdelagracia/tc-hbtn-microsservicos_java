package com.example.calculator.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/calculator/welcome");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    private static Stream<Arguments> addNumbersParameters() {
        return Stream.of(
                Arguments.of(2.0, 3.0, "5.0"),
                Arguments.of(5.0, 3.0, "8.0"),
                Arguments.of(4.0, 3.0, "7.0")
        );
    }

    @ParameterizedTest
    @MethodSource("addNumbersParameters")
    void addNumbers(Double number1, Double number2, String expected) throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/calculator/addNumbers?number1=" + number1 + "&number2=" + number2);
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @ParameterizedTest
    @CsvSource({"5.0, 3.0, '2.0'", "10.0, 5.0, '5.0'"})
    void subNumbers(Double number1, Double number2, String expected) throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/calculator/subNumbers?number1=" + number1 + "&number2=" + number2);
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @ParameterizedTest
    @CsvSource({"6.0, 3.0, '2.0'", "10.0, 5.0, '2.0'"})
    void divideNumbers(Double number1, Double number2, String expected) throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/calculator/divideNumbers?number1=" + number1 + "&number2=" + number2);
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @ParameterizedTest
    @CsvSource({"4, '24'", "10, '3628800'"})
    void factorial(Integer factorial,  String expected) throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/calculator/factorial?factorial=" + factorial) ;
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception{
        LocalDate localDate1 = LocalDate.of(2022,8,2);
        LocalDate localDate2 = LocalDate.of(2022,8,29);
        String expected = "27";
        RequestBuilder request = MockMvcRequestBuilders.get("/calculator/calculeDayBetweenDate?localDate1=" + localDate1 +"&localDate2="+ localDate2);
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @ParameterizedTest
    @CsvSource({"3, '11'", "12, '1100'"})
    void integerToBinary(Integer integer,  String expected) throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/calculator/integerToBinary?number1=" + integer) ;
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @ParameterizedTest
    @CsvSource({"16, '10'", "27, '1b'"})
    void integerToHexadecimal(Integer integer,  String expected) throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/calculator/integerToHexadecimal?number1=" + integer) ;
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(expected, result.getResponse().getContentAsString());
    }
}


