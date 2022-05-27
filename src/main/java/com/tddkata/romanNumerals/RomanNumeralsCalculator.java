package com.tddkata.romanNumerals;

import java.util.Map;

public class RomanNumeralsCalculator {

    private static final Map<Integer, String> symbols = Map.of(
            0, "",
            1, "I",
            4, "IV",
            5, "V"
    );


    public String convertNumber(int number) {
        if (number >= 5) {
            return symbols.get(5) + convertNumber(number - 5);
        }
        if (number >= 4) {
            return symbols.get(4) + convertNumber(number - 4);
        }
        if (number >= 1) {
            return symbols.get(1) + convertNumber(number - 1);
        }

        return symbols.get(0);
    }
}
