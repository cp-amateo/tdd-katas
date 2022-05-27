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
                Arguments.of(1, "I"),
                Arguments.of(2, "II"),
                Arguments.of(3, "III"),
                Arguments.of(4, "IV"),
                Arguments.of(5, "V"),
                Arguments.of(6, "VI"),
                Arguments.of(7, "VII"),
                Arguments.of(8, "VIII"),
                Arguments.of(9, "IX"),
                Arguments.of(10, "X"),
                Arguments.of(14, "XIV"),
                Arguments.of(19, "XIX"),
                Arguments.of(20, "XX"),
                Arguments.of(30, "XXX"),
                Arguments.of(40, "XL"),
                Arguments.of(50, "L")
        );
    }
}