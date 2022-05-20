package com.tddkata.BowlingGame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public static final int PINS_IN_GAME = 10;
    private int hitsCount;

    private List<Integer> hits = new ArrayList();

    public void roll(int pins) {
        if (pins > PINS_IN_GAME || pins < 0) {
            throw new RuntimeException();
        }
        hitsCount += pins;
        hits.add(pins);
    }

    public int score() {
        int spareBonus = 0;
        for (int rollNumber = 0; rollNumber < 20; rollNumber++) {
            if (rollNumber % 2 == 1
                && (hits.get(rollNumber) + hits.get(rollNumber - 1)) == 10) {
                spareBonus += hits.get(rollNumber+1);
            }
        }

        return hitsCount + spareBonus;

    }
}
