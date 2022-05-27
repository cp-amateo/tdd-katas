package com.tddkata.gameOfLife;

import lombok.Getter;

public class GameOfLife {

    @Getter
    private boolean[][] board;

    public GameOfLife(boolean[][] board) {
        this.board = board;
    }

    public void nextGen() {
        boolean[][] nextBoard = new boolean[board.length][board[0].length];

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                nextBoard[x][y] = board[x][y];

                int nAlive = getNumberOfAliveCells(x, y);

                if (board[x][y] && nAlive < 2) {
                    nextBoard[x][y] = false;
                }
                if (!board[x][y] && nAlive == 3) {
                    nextBoard[x][y] = true;
                }
                if (board[x][y] && nAlive > 3) {
                    nextBoard[x][y] = false;
                }

            }
        }

        this.board = nextBoard;
    }

    private int getNumberOfAliveCells(int xCell, int yCell) {
        int nAlive = 0;

        for (int x = xCell - 1; x <= xCell + 1; x++) {
            for (int y = yCell - 1; y <= yCell + 1; y++) {
                if (xCell != x || yCell != y) {
                    nAlive += cellAlive(x, y);
                }
            }
        }

        return nAlive;
    }

    private int cellAlive(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }
        if (x >= board.length) {
            return 0;
        }
        if (y >= board[x].length) {
            return 0;
        }

        return board[x][y] ? 1 : 0;
    }

}
