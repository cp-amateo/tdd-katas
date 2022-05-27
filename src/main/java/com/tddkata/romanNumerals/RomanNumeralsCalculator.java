package com.tddkata.romanNumerals;

public class RomanNumeralsCalculator {

    public String convertNumber(int number) {
        if (number == 1) {
            return "I" + convertNumber(0);
        }

        return "";
    }
}
