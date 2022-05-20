package com.tddkata.BowlingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BowlingGameShould {

    private BowlingGame bowlingGame;

    @BeforeEach
    void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    void return_zero_when_not_hit_any_pin() {
        for (int rollNumber = 0; rollNumber < 20; rollNumber++) {
            bowlingGame.roll(0);
        }

        assertThat(bowlingGame.score()).isEqualTo(0);
    }

    @Test
    void return_one_when_hit_one_pin() {
        bowlingGame.roll(1);
        for (int rollNumber = 0; rollNumber < 19; rollNumber++) {
            bowlingGame.roll(0);
        }

        assertThat(bowlingGame.score()).isEqualTo(1);
    }

    @Test
    void throws_exception_when_hits_max_of_pins() {
        assertThrows(RuntimeException.class, () -> bowlingGame.roll(11));
    }

    @Test
    void throws_exception_when_hits_negative_pins() {
        assertThrows(RuntimeException.class, () -> bowlingGame.roll(-1));
    }
}