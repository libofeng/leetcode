package com.leetcode.array;

public class No289GameOfLife {
    public void gameOfLife(int[][] board) {
        final int[] dx = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        final int[] dy = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
        final int xLen = board.length, yLen = board[0].length;

        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                int living = 0;
                for (int k = 0; k < 8; k++) {
                    final int x = i + dx[k], y = j + dy[k];
                    if (x > -1 && y > -1 && x < xLen && y < yLen &&
                            (board[x][y] == 1 || board[x][y] == 2)) living++;
                }

                if (board[i][j] == 1 && (living < 2 || living > 3)) board[i][j] = 2;
                else if (board[i][j] == 0 && living == 3) board[i][j] = 3;
            }
        }

        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
}
