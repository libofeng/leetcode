package com.lintcode.dp;

public class No515PaintHouse {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        final int m = costs.length, n = m == 0 ? 0 : costs[0].length;
        int[][] dp = new int[m + 1][n];

        int minCost = 0;
        for (int i = 1; i <= m; i++) {
            minCost = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) if (k != j) min = Math.min(min, dp[i - 1][k] + costs[i - 1][j]);
                dp[i][j] = min;
                minCost = Math.min(minCost, min);
            }
        }

        return minCost;
    }

    // simplified space complexity
    public int minCost2(int[][] costs) {
        final int m = costs.length, n = m == 0 ? 0 : costs[0].length;
        int[][] dp = new int[2][n];

        int minCost = 0;
        for (int i = 1; i <= m; i++) {
            minCost = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) if (k != j) min = Math.min(min, dp[0][k] + costs[i - 1][j]);
                dp[1][j] = min;
                minCost = Math.min(minCost, min);
            }

            System.arraycopy(dp[1], 0, dp[0], 0, n);
        }

        return minCost;
    }

    public int minCostII(int[][] costs) {
        final int m = costs.length, n = m == 0 ? 0 : costs[0].length;
        final int[] curr = new int[n], prevMin = new int[n];

        int min = 0;
        for (int i = 0; i < m; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                curr[j] = prevMin[j] + costs[i][j];
                if (j > 0) min = Math.min(min, curr[j - 1]);
                prevMin[j] = min;
            }

            min = curr[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                prevMin[j] = Math.min(min, prevMin[j]);
                min = Math.min(min, curr[j]);
            }
        }

        return min;
    }
}
