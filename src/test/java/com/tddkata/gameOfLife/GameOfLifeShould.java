package com.tddkata.gameOfLife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeShould {


    @Test
    void return_all_deaths_when_board_is_all_death() {
        final boolean[][] board = new boolean[][]{
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };

        final GameOfLife gameOfLife = new GameOfLife(board);

        gameOfLife.nextGen();

        assertThat(gameOfLife.getBoard()).isEqualTo(board);
    }
}