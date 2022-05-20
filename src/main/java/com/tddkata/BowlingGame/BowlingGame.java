package com.tddkata.BowlingGame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public static final int PINS_IN_GAME = 10;
    public static final int MAX_STANDARD_ROLLS = 20;
    private final List<Integer> hits = new ArrayList();

    public void roll(int pins) {
        if (pins > PINS_IN_GAME || pins < 0) {
            throw new RuntimeException();
        }
        hits.add(pins);
    }

    public int score() {
        return calculateBaseScore() +
               calculateSpareBonus();

    }

    private int calculateBaseScore() {
        return hits.stream().mapToInt(Integer::intValue).sum();
    }

    private int calculateSpareBonus() {
        int spareBonus = 0;
        for (int rollNumber = 0; rollNumber < MAX_STANDARD_ROLLS; rollNumber++) {
            if (isRollNumberOdd(rollNumber)
                && isSpare(rollNumber)) {
                spareBonus += hits.get(rollNumber + 1);
            }
        }
        return spareBonus;
    }

    private boolean isSpare(int rollNumber) {
        return (hits.get(rollNumber) + hits.get(rollNumber - 1)) == 10;
    }

    private boolean isRollNumberOdd(int rollNumber) {
        return rollNumber % 2 == 1;
    }
}
