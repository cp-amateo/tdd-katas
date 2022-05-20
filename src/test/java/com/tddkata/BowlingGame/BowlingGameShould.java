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
        rollWithoutHits(20);

        assertThat(bowlingGame.score()).isEqualTo(0);
    }

    @Test
    void return_one_when_hit_one_pin() {
        bowlingGame.roll(1);
        rollWithoutHits(19);

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

    @Test
    void calculate_bonus_when_spare() {
        rollHits(5, 5, 2);
        rollWithoutHits(17);

        assertThat(bowlingGame.score()).isEqualTo(14);
    }

    private void rollHits(int... hits) {
        for (int hit : hits) {
            bowlingGame.roll(hit);
        }
    }

    private void rollWithoutHits(int numberOfRolls) {
        for (int rollNumber = 0; rollNumber < numberOfRolls; rollNumber++) {
            bowlingGame.roll(0);
        }
    }


}