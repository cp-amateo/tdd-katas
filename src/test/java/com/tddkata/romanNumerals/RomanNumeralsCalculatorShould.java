package com.tddkata.romanNumerals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsCalculatorShould {

    @Test
    void return_I_when_convert_one() {
        final String result = new RomanNumeralsCalculator().convert(1);
        assertThat(result).isEqualTo("I");
    }

}