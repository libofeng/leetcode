package com.leetcode.array;

public class No221MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '0') continue;
                dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }

    public int maximalSquare2(char[][] matrix) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) max = Math.max(max, expand(matrix, i, j));
        }

        return max * max;
    }

    private int expand(char[][] matrix, int row, int col) {
        int max = 0, maxCol = matrix[0].length;

        for (int i = row; i < matrix.length && matrix[i][col] == '1'; i++) {

            for (int j = col; j < maxCol; j++) if (matrix[i][j] == '0') maxCol = j;
            if (maxCol - col <= i - row + 1) return maxCol - col;

            max = i - row + 1;
        }

        return max;
    }
}
