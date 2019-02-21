package com.leetcode.array;

public class No348DesignTicTacToe {
    private int[][] rows;
    private int[][] cols;
    private int[] diagonal = new int[2];
    private int[] reverseDiagonal = new int[2];
    private int size;

    /**
     * Initialize your data structure here.
     */
    public No348DesignTicTacToe(int n) {
        size = n;
        rows = new int[n][2];
        cols = new int[n][2];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        if (++rows[row][player - 1] == size) return player;
        if (++cols[col][player - 1] == size) return player;

        if (row == col && ++diagonal[player - 1] == size) return player;
        if (row + col == size - 1 && reverseDiagonal[player - 1] == size) return player;

        return 0;
    }
}
