package com.lintcode.dp;

public class No436MaximalSquare {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) max = Math.max(max, findMax(matrix, i, j));
            }
        }

        return max;
    }

    private int findMax(int[][] matrix, int row, int col) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;

        int height = 0, minWidth = n, max = 0;
        for (int i = row; i < m && matrix[i][col] == 1; i++) {
            height++;

            int j = col;
            while (j < n && matrix[i][j] == 1) j++;
            minWidth = Math.min(minWidth, j - col);

            int width = Math.min(minWidth, height);
            max = Math.max(max, width * width);
        }

        return max;
    }


    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare2(int[][] matrix) {
        //  dp[i][j] = min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1])) + 1;
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        final int[][] dp = new int[m][n];

        int width = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
            if (matrix[i][0] == 1) width = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
            if (matrix[0][j] == 1) width = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    int min = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    dp[i][j] = min + 1;
                    width = Math.max(width, dp[i][j]);
                }
            }
        }

        return width * width;
    }
}
