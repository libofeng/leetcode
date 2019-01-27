package com.leetcode.math;

import java.util.Arrays;

public class No279PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) dp[i] = 1;
            else {
                for (int j = 1; j <= i / 2; j++) dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }

        return dp[n];
    }

    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i * i <= n; i++) dp[i * i] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 1; i + j * j <= n; j++) dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);

        return dp[n];
    }
}
