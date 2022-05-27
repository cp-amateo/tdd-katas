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
                int nAlive = 0;
                if (isCellAlive(board, x - 1, y - 1)) nAlive++;
                if (isCellAlive(board, x - 1, y)) nAlive++;
                if (isCellAlive(board, x - 1, y + 1)) nAlive++;
                if (isCellAlive(board, x + 1, y - 1)) nAlive++;
                if (isCellAlive(board, x + 1, y)) nAlive++;
                if (isCellAlive(board, x + 1, y + 1)) nAlive++;
                if (isCellAlive(board, x, y - 1)) nAlive++;
                if (isCellAlive(board, x, y + 1)) nAlive++;

                nextBoard[x][y] = board[x][y];

                if (board[x][y] && nAlive <= 2) {
                    nextBoard[x][y] = false;
                }
                if (!board[x][y] && nAlive == 3) {
                    nextBoard[x][y] = true;
                }

            }
        }

        this.board = nextBoard;
    }

    private boolean isCellAlive(boolean[][] board, int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }
        if (x >= board.length) {
            return false;
        }
        if (y >= board[x].length) {
            return false;
        }

        return board[x][y];
    }

}
