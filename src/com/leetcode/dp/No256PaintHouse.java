package com.leetcode.dp;

public class No256PaintHouse {
    /*
    There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

    The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

    Note:
    All costs are positive integers.

    Example:

    Input: [[17,2,17],[16,16,5],[14,3,19]]
    Output: 10
    Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
                 Minimum cost: 2 + 5 + 3 = 10.

     */
    public int minCost(int[][] costs) {
        final int n = costs.length;
        if (n == 0) return 0;

        final int[][] dp = new int[n][3];
        for (int j = 0; j < 3; j++) dp[0][j] = costs[0][j];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }

    public int minCost2(int[][] costs) {
        final int n = costs.length;
        if (n == 0) return 0;

        final int[][] dp = new int[2][3];
        for (int j = 0; j < 3; j++) dp[0][j] = costs[0][j];

        for (int i = 1; i < n; i++) {
            dp[1][0] = Math.min(dp[0][1], dp[0][2]) + costs[i][0];
            dp[1][1] = Math.min(dp[0][0], dp[0][2]) + costs[i][1];
            dp[1][2] = Math.min(dp[0][0], dp[0][1]) + costs[i][2];

            dp[0][0] = dp[1][0];
            dp[0][1] = dp[1][1];
            dp[0][2] = dp[1][2];
        }

        return Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]);
    }

    // it's the same as solution #2
    public int minCost3(int[][] costs) {
        final int n = costs.length;
        if (n == 0) return 0;

        int minRed = costs[0][0], minBlue = costs[0][1], minGreen = costs[0][2];
        for (int i = 1; i < n; i++) {
            int red = costs[i][0] + Math.min(minBlue, minGreen);
            int blue = costs[i][1] + Math.min(minRed, minGreen);
            int gree = costs[i][2] + Math.min(minRed, minBlue);

            minRed = red;
            minBlue = blue;
            minGreen = gree;
        }

        return Math.min(Math.min(minRed, minBlue), minGreen);
    }
}
