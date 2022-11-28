package com.epam.rd.autotasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FactorialRegularInputTesting {

    Factorial factorial = new Factorial();

    public static Stream<Arguments> testCases() {
        return Stream.of(Arguments.of("0", "1"),
                Arguments.of("13", "6227020800"),
                Arguments.of("7", "5040"),
                Arguments.of("16", "20922789888000"));
    }


    @ParameterizedTest
    @MethodSource("testCases")
    void testFactorial(String in, String expected) {
        Assertions.assertEquals(factorial.factorial(in), expected);
    }
}
