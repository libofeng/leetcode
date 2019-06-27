package com.leetcode.array;

public class No289GameOfLife {
    private int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public void gameOfLife(int[][] board) {
        final int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int living = 0;
                for (int[] dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n) continue;
                    if (board[x][y] == 1 || board[x][y] == 2) living++;
                }

                if (board[i][j] == 1 && (living < 2 || living > 3)) board[i][j] = 2;
                else if (board[i][j] == 0 && living == 3) board[i][j] = 3;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) board[i][j] = (board[i][j] & 1);
        }
    }
}
