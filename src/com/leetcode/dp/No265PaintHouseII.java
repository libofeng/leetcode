package com.leetcode.dp;

public class No265PaintHouseII {
    /*
There are a row of n houses, each house can be painted with one of the k colors.
The cost of painting each house with a certain color is different.
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix.
For example, costs[0][0] is the cost of painting house 0 with color 0;
costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Example:

Input: [[1,5,3],[2,9,4]]
Output: 5
Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
             Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
Follow up:
Could you solve it in O(nk) runtime?
     */

    public int minCostII(int[][] costs) {
        final int n = costs.length, k = n == 0 ? 0 : costs[0].length;
        if (n == 0) return 0;

        final int[][] dp = new int[2][k];
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) min = Math.min(min, dp[0][j] = costs[0][j]);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[1][j] = Integer.MAX_VALUE;
                for (int l = 0; l < k; l++) {
                    if (j != l) dp[1][j] = Math.min(dp[1][j], dp[0][l]);
                }
                dp[1][j] += costs[i][j];
            }

            min = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) min = Math.min(min, dp[0][j] = dp[1][j]);
        }

        return min;
    }

    // https://www.cnblogs.com/Dylan-Java-NYC/p/5327633.html
    public int minCostII2(int[][] costs) {
        final int n = costs.length, k = n == 0 ? 0 : costs[0].length;

        int minCost = 0, min2Cost = 0, minIndex = -1;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE, min2 = min, index = -1;
            for (int j = 0; j < k; j++) {
                int cost = ((minIndex == j) ? min2Cost : minCost) + costs[i][j];
                if (cost < min) {
                    min2 = min;
                    min = cost;
                    index = j;
                } else if (cost < min2) min2 = cost;
            }

            minCost = min;
            min2Cost = min2;
            minIndex = index;
        }

        return minCost;
    }
}
