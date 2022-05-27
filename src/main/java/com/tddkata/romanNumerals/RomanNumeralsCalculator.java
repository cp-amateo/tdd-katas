package com.tddkata.romanNumerals;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class RomanNumeralsCalculator {

    private final TreeMap<Integer, String> symbols = initializeSymbols();

    private TreeMap<Integer, String> initializeSymbols() {
        final TreeMap<Integer, String> symbols = new TreeMap<>();
        symbols.putAll(Map.of(
                0, "",
                1, "I",
                4, "IV",
                5, "V",
                9, "IX",
                10, "X"
        ));
        return symbols;
    }

    public String convertNumber(int number) {
        final int key = getKey(number);
        if (key == 0) {
            return symbols.get(0);
        }
        return symbols.get(key) + convertNumber(number - key);
    }

    private int getKey(int number) {

        return symbols.floorKey(number);
    }
}
