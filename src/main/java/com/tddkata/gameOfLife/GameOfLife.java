package com.tddkata.gameOfLife;

import lombok.Getter;

public class GameOfLife {

    @Getter
    private final boolean[][] board;

    public GameOfLife(boolean[][] board) {
        this.board = board;
    }

    public void nextGen() {

    }

}
