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

        assertThat(gameOfLife.getBoard()[1][1]).isFalse();
    }

    @Test
    void return_all_deaths_after_ome_step_when_only_one_cell_alive() {
        final boolean[][] board = new boolean[][]{
                {false, false, false},
                {false, true, false},
                {false, false, false}
        };

        final GameOfLife gameOfLife = new GameOfLife(board);
        gameOfLife.nextGen();

        assertThat(gameOfLife.getBoard()[1][1]).isFalse();
    }

    @Test
    void become_alive_when_exactly_3_neighbours_alive() {
        final boolean[][] board = new boolean[][]{
                {true, true, false},
                {false, false, false},
                {false, false, true}
        };

        final GameOfLife gameOfLife = new GameOfLife(board);
        gameOfLife.nextGen();

        assertThat(gameOfLife.getBoard()[1][1]).isTrue();
    }

    @Test
    void death_when_more_than_3_neighbours_alive() {
        final boolean[][] board = new boolean[][]{
                {true, true, false},
                {false, true, false},
                {true, false, true}
        };

        final GameOfLife gameOfLife = new GameOfLife(board);
        gameOfLife.nextGen();

        assertThat(gameOfLife.getBoard()[1][1]).isFalse();
    }

    @Test
    void any_live_cell_with_2_or_3_alive_cells_will_be_survive() {
        final boolean[][] board = new boolean[][]{
                {true, true, false},
                {false, true, false},
                {false, false, false}
        };

        final GameOfLife gameOfLife = new GameOfLife(board);
        gameOfLife.nextGen();

        assertThat(gameOfLife.getBoard()[1][1]).isTrue();
    }

    @Test
    void test_initial_square() {
        final boolean[][] board = new boolean[][]{
                {false, false, false, false},
                {false, true, true, false},
                {false, true, true, false},
                {false, false, false, false},
        };

        final GameOfLife gameOfLife = new GameOfLife(board);
        for (int i = 0; i < 10; i++) {
            gameOfLife.nextGen();
        }

        final boolean[][] expectedBoard = new boolean[][]{
                {false, false, false, false},
                {false, true, true, false},
                {false, true, true, false},
                {false, false, false, false},
        };

        assertThat(gameOfLife.getBoard()).isEqualTo(expectedBoard);
    }

    @Test
    void test_initial_line() {
        final boolean[][] board = new boolean[][]{
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, true, true, true, true, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},

        };
        final GameOfLife gameOfLife = new GameOfLife(board);
        for (int i = 0; i < 10; i++) {
            gameOfLife.nextGen();
        }
        final boolean[][] expectedBoard = new boolean[][]{
                {false, false, false, false, false, false},
                {false, false, true, true, false, false},
                {false, true, false, false, true, false},
                {false, false, true, true, false, false},
                {false, false, false, false, false, false},
        };

        assertThat(gameOfLife.getBoard()).isEqualTo(expectedBoard);
    }

}