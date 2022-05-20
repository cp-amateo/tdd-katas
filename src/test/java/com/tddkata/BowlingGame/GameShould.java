package com.tddkata.BowlingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameShould {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void return_zero_when_not_hit_any_pin() {
        for (int rollNumber = 0; rollNumber < 20; rollNumber++) {
            game.roll(0);
        }

        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    void return_one_when_hit_one_pin() {
        game.roll(1);
        for (int rollNumber = 0; rollNumber < 19; rollNumber++) {
            game.roll(0);
        }

        assertThat(game.score()).isEqualTo(-1);
    }
}