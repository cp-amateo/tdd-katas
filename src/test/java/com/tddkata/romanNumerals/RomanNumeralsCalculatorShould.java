package com.tddkata.romanNumerals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsCalculatorShould {

    private RomanNumeralsCalculator romanNumeralsCalculator = new RomanNumeralsCalculator();

    @Test
    void return_I_when_empty() {
        String romanNumber = romanNumeralsCalculator.convertNumber(0);
        assertThat(romanNumber).isEqualTo("");
    }

    @Test
    void return_I_when_one() {
        String romanNumber = romanNumeralsCalculator.convertNumber(1);
        assertThat(romanNumber).isEqualTo("I");
    }
}