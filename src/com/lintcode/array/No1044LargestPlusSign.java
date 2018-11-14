package com.lintcode.array;

import java.util.Arrays;

public class No1044LargestPlusSign {

    /**
     * @param N:     size of 2D grid
     * @param mines: in the given list
     * @return: the order of the plus sign
     */
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        final int[][] grid = new int[N][N];
        for (int[] row : grid) Arrays.fill(row, 1);
        for (int[] p : mines) grid[p[0]][p[1]] = 0;

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) max = Math.max(max, expand(N, grid, i, j));
            }
        }

        return max;
    }

    private int expand(int N, int[][] grid, int x, int y) {
        int top = y, bottom = y, left = x, right = x;

        while (left > 0 && grid[left - 1][y] == 1 && right < N - 1 && grid[right + 1][y] == 1) {
            left--;
            right++;
        }

        while (top > 0 && grid[x][top - 1] == 1 && bottom < N - 1 && grid[x][bottom + 1] == 1) {
            top--;
            bottom++;
        }

        return Math.min(right - left, bottom - top) / 2 + 1;
    }

    // http://www.cnblogs.com/grandyang/p/8679286.html
    public int orderOfLargestPlusSign2(int N, int[][] mines) {
        final int[][] dp = new int[N][N];
        for(int[] row : dp) Arrays.fill(row, N);
        for(int[] p : mines) dp[p[0]][p[1]] = 0;

        for(int i = 0; i<N; i++){
            int l = 0, r = 0, u = 0, b = 0;
            for(int j = 0, k = N - 1; j<N && k>=0;j++, k--){
                dp[i][j] = Math.min(dp[i][j], l = dp[i][j] == 0 ? 0: l + 1);
                dp[j][i] = Math.min(dp[j][i], u = dp[j][i] == 0 ? 0: u + 1);
                dp[i][k] = Math.min(dp[i][k], r = dp[i][k] == 0 ? 0: r + 1);
                dp[k][i] = Math.min(dp[k][i], b = dp[k][i] == 0 ? 0: b + 1);
            }
        }

        int max = 0;
        for(int[] row : dp) for(int v : row) max= Math.max(max, v);
        return max;
    }
}
