package com.leetcode.array;

public class No723CandyCrush {
    public int[][] candyCrush(int[][] board) {
        final int m = board.length, n = m == 0 ? 0 : board[0].length;

        boolean crushFound = true;
        while (crushFound) {
            crushFound = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int val = Math.abs(board[i][j]);
                    if (val == 0) continue;

                    if (i < m - 2 && val == Math.abs(board[i + 1][j]) && val == Math.abs(board[i + 2][j])) {
                        crushFound = true;
                        for (int k = i; k < m && Math.abs(board[k][j]) == val; k++) board[k][j] = -val;
                    }

                    if (j < n - 2 && val == Math.abs(board[i][j + 1]) && val == Math.abs(board[i][j + 2])) {
                        crushFound = true;
                        for (int k = j; k < n && Math.abs(board[i][k]) == val; k++) board[i][k] = -val;
                    }

                }
            }

            if (!crushFound) break;

            for (int j = 0; j < n; j++) {
                int index = m - 1;
                for (int i = m - 1; i >= 0; i--) if (board[i][j] > 0) board[index--][j] = board[i][j];
                for (int i = index; i >= 0; i--) board[i][j] = 0;
            }
        }

        return board;
    }
}
