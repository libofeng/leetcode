package com.leetcode.contest.contest135;

public class No5047MinimumScoreTriangulationOfPolygon {
    // https://www.youtube.com/watch?v=d9FFzpP9GLk
    // O(N^3)
    public int minScoreTriangulation(int[] A) {
        final int n = A.length;
        final int[][] dp = new int[n][n];
        for (int d = 2; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
