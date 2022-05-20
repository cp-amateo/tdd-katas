package com.tddkata.BowlingGame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public static final int PINS_IN_GAME = 10;
    public static final int MAX_STANDARD_ROLLS = 20;
    private final List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        if (pins > PINS_IN_GAME || pins < 0) {
            throw new RuntimeException();
        }
        rolls.add(pins);
    }

    public int score() {
        return calculateBaseScore() +
               calculateSpareBonus();

    }

    private int calculateBaseScore() {
        return rolls.stream().mapToInt(Integer::intValue).sum();
    }

    private int calculateSpareBonus() {
        int spareBonus = 0;
        for (int rollNumber = 2; rollNumber < rolls.size(); rollNumber += 2) {
            if (isSpare(rollNumber)) {
                spareBonus += rolls.get(rollNumber);
            }
        }
        return spareBonus;
    }

    private boolean isSpare(int rollNumber) {
        return (rolls.get(rollNumber - 1) + rolls.get(rollNumber - 2)) == 10;
    }

}
