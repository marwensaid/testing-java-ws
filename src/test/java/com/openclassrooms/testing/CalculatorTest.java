package com.openclassrooms.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

class CalculatorTest {

    private Calculator calculatorUnderTest;

    private static Instant start;

    @BeforeEach
    public void initCalculator() {
        System.out.println("init calculator before each test");
        calculatorUnderTest = new Calculator();
    }

    @AfterEach
    public void calculatorNull() {
        System.out.println("null after each test");
        calculatorUnderTest = null;
    }

    @BeforeAll
    public static void initTime() {
        System.out.println("time before exec");
        start = Instant.now();
    }

    @AfterAll
    public static void duration() {
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();

        System.out.println(MessageFormat.format("my duration : {0}", duration));
    }


    @Test
    void testAddTwoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int somme = calculatorUnderTest.add(a, b);

        // Assert
        assertEquals(5, somme);
    }

    @Test
    void multiplyCalculatorTest() {
        int a = 5;
        int b = 4;

        int multiply = calculatorUnderTest.multiply(a, b);

        assertEquals(20, multiply);


    }

}
