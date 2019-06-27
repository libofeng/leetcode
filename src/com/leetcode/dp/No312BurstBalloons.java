package com.leetcode.dp;

public class No312BurstBalloons {
    public int maxCoins(int[] nums) {
        final int[] balloons = new int[nums.length + 2];

        int n = 1;
        for (int i = 0; i < nums.length; i++) if (nums[i] != 0) balloons[n++] = nums[i];
        balloons[0] = balloons[n++] = 1;

        return dfs(balloons, 0, n - 1, new int[n][n]);
    }

    private int dfs(int[] balloons, int left, int right, int[][] coins) {
        if (right - left <= 1) return 0;
        if (coins[left][right] > 0) return coins[left][right];

        for (int i = left + 1; i < right; i++) {
            int coin = balloons[left] * balloons[i] * balloons[right];
            coin += dfs(balloons, left, i, coins);
            coin += dfs(balloons, i, right, coins);

            coins[left][right] = Math.max(coins[left][right], coin);
        }

        return coins[left][right];
    }


    public int maxCoins2(int[] nums) {
        final int[] balloons = new int[nums.length + 2];

        int n = 1;
        for (int i = 0; i < nums.length; i++) if (nums[i] != 0) balloons[n++] = nums[i];
        balloons[0] = balloons[n++] = 1;

        final int[][] dp = new int[n][n];
        for (int gap = 2; gap < n; gap++) {
            for (int left = 0, right = left + gap; right < n; left++, right++) {
                for (int i = left + 1; i < right; i++) {
                    int coin = balloons[left] * balloons[right] * balloons[i];
                    coin += dp[left][i];
                    coin += dp[i][right];

                    dp[left][right] = Math.max(dp[left][right], coin);
                }
            }
        }

        return dp[0][n - 1];
    }
}
