package com.tddkata.romanNumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsCalculatorShould {

    private RomanNumeralsCalculator romanNumeralsCalculator = new RomanNumeralsCalculator();


    @ParameterizedTest
    @MethodSource("romanNumberEquivalences")
    void return_I_when_one(int number, String expectedRomanNumber) {
        String romanNumber = romanNumeralsCalculator.convertNumber(number);
        assertThat(romanNumber).isEqualTo(expectedRomanNumber);
    }

    private static Stream<Arguments> romanNumberEquivalences() {
        return Stream.of(
                Arguments.of(0, ""),
                Arguments.of(1, "I")
        );
    }
}