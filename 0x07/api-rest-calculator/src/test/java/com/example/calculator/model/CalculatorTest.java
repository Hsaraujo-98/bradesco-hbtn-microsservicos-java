package com.example.calculator.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void sumTest() {
        Double result = calculator.sum(10.0, 5.0);
        assertEquals(15.0, result);
    }

    @Test
    void numbersNullSumTest() {
        NullPointerException ex = assertThrows(NullPointerException.class,
                () -> calculator.sum(null, 1.0));
        assertEquals("Número 1 e número 2 são obrigatórios.", ex.getMessage());

        ex = assertThrows(NullPointerException.class,
                () -> calculator.sum(1.0, null));
        assertEquals("Número 1 e número 2 são obrigatórios.", ex.getMessage());
    }

    @Test
    void subTest() {
        Double result = calculator.sub(10.0, 3.0);
        assertEquals(7.0, result);
    }

    @Test
    void divideTest() {
        Double result = calculator.divide(10.0, 2.0);
        assertEquals(5.0, result);
    }

    @Test
    void divisionByZeroTest() {
        ArithmeticException ex = assertThrows(ArithmeticException.class,
                () -> calculator.divide(10.0, 0.0));
        assertEquals("Divisão por zero não é permitido.", ex.getMessage());
    }

    @Test
    void factorialTest() {
        assertEquals(1, calculator.factorial(0)); // 0! = 1
        assertEquals(1, calculator.factorial(1)); // 1! = 1
        assertEquals(120, calculator.factorial(5)); // 5! = 120
    }

    @Test
    void integerToBinaryTest() {
        assertEquals(1, calculator.integerToBinary(1)); // 1 -> "1" -> 1
        assertEquals(101, calculator.integerToBinary(5)); // 5 -> "101" -> 101
        assertEquals(10100, calculator.integerToBinary(20)); // 20 -> "10100" -> 10100
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("1", calculator.integerToHexadecimal(1));
        assertEquals("5", calculator.integerToHexadecimal(5));
        assertEquals("AA", calculator.integerToHexadecimal(170));
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate d1 = LocalDate.of(2020, 3, 15);
        LocalDate d2 = LocalDate.of(2020, 3, 29);
        assertEquals(14, calculator.calculeDayBetweenDate(d1, d2));

        // inversão de ordem deve manter a diferença absoluta
        assertEquals(14, calculator.calculeDayBetweenDate(d2, d1));
    }
}