package com.tddkata.BowlingGame;

public class BowlingGame {

    private int score;

    public void roll(int pins) {
        if (pins > 10) {
            throw new RuntimeException();
        }
        score += pins;
    }

    public int score() {
        return score;
    }
}
