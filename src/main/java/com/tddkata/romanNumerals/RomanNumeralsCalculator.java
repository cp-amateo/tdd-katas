package com.tddkata.romanNumerals;

public class RomanNumeralsCalculator {

    public String convertNumber(int number) {
        if (number >= 5) {
            return "V" + convertNumber(number - 5);
        }
        if (number >= 4) {
            return "IV" + convertNumber(number - 4);
        }
        if (number >= 1) {
            return "I" + convertNumber(number - 1);
        }

        return "";
    }
}
