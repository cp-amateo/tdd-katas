package com.tddkata.BowlingGame;

public class BowlingGame {

    public static final int PINS_IN_GAME = 10;
    private int score;

    public void roll(int pins) {
        if (pins > PINS_IN_GAME) {
            throw new RuntimeException();
        }
        score += pins;
    }

    public int score() {
        return score;
    }
}
