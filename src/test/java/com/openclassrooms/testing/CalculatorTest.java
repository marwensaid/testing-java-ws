package com.openclassrooms.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        // Assert with AssertJ
        assertThat(somme).isEqualTo(5);
    }

    @Test
    void multiplyCalculatorTest() {
        int a = 5;
        int b = 4;

        int multiply = calculatorUnderTest.multiply(a, b);

        assertEquals(20, multiply);


    }

    @ParameterizedTest(name = "{0} * 0 should result 0")
    @ValueSource(ints = {1, 21, 42, 63, 98})
    public void multiplyZero(int var) {

        int multiply = calculatorUnderTest.multiply(var, 0);

        assertEquals(0, multiply);
    }


    @ParameterizedTest(name = "{0} * {1} should equal {2}")
    @CsvSource({"3,2,6", "4,4,16"})
    public void multiplyManyArgs(int var, int var2, int expectedResult) {

        int multiply = calculatorUnderTest.multiply(var, var2);

        assertEquals(expectedResult, multiply);
    }

    @Test
    public void digitalNumberTest() {
        int number = 5368;

        Set<Integer> actualResult = calculatorUnderTest.digitalOp(number);

        // Assert with AssertJ
        assertThat(actualResult).containsExactlyInAnyOrder(5, 6, 3, 8);

        // assert with Junit
        Set<Integer> expectedResult = Stream.of(5, 3, 6, 8).collect(Collectors.toSet());
        assertEquals(expectedResult, actualResult);

    }

}
