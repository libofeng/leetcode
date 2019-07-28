package com.leetcode.contest.contest147;

public class No1139Largest1BorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        final int m = grid.length, n = grid[0].length;

        int[][] right = new int[m][n], down = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) continue;
                right[i][j] = (j + 1 == n ? 0 : right[i][j + 1]) + 1;
                down[i][j] = (i + 1 == m ? 0 : down[i + 1][j]) + 1;
            }
        }

        int maxLen = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) continue;
                int len = Math.min(right[i][j], down[i][j]);
                for (int k = len - 1; k >= 0; k--) {
                    if (right[i + k][j] >= k && down[i][j + k] > k) {
                        maxLen = Math.max(maxLen, k + 1);
                        break;
                    }
                }
            }
        }

        return maxLen * maxLen;
    }
}
