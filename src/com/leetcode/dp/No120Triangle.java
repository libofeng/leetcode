package com.leetcode.dp;

import java.util.List;

public class No120Triangle {
    // top-down
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, triangle.get(i).get(j)
                        + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }

    // bottom-up
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;

        final int[][] dp = new int[triangle.size()][triangle.size()];
        int min = triangle.get(0).get(0);
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            int listMin = Integer.MAX_VALUE;

            for (int j = 0; j < triangle.get(i).size(); j++) {
                int n = triangle.get(i).get(j);
                if (j > 0 && j < triangle.get(i).size() - 1) dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + n;
                else if (j > 0) dp[i][j] = dp[i - 1][j - 1] + n;
                else dp[i][j] = dp[i - 1][j] + n;

                listMin = Math.min(listMin, dp[i][j]);
            }

            min = listMin;
        }

        return min;
    }
}
