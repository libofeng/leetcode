package com.leetcode.contest.contest137;

public class No1049LastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        final int n = stones.length;
        final int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                dp[j][i] = Integer.MAX_VALUE;
                if (j == i) dp[j][i] = Math.min(dp[j][i], stones[i]);
                else {
                    dp[j][i] = Math.min(dp[j][i], Math.abs(stones[j] - dp[j + 1][i]));

                    dp[j][i] = Math.min(dp[j][i], Math.abs(stones[i] - dp[j][i - 1]));
                }
            }
        }

        return dp[0][n - 1];
    }


    // https://leetcode.com/problems/last-stone-weight-ii/discuss/294888/JavaC%2B%2BPython-Easy-Knapsacks-DP
    public int lastStoneWeight2(int[] A) {
        int[] dp = new int[1501];
        dp[0] = 1;
        int sumA = 0, res = 100;
        for (int a : A) {
            sumA += a;
            for (int i = 1500; i >= a; --i)
                dp[i] |= dp[i - a];
        }
        for (int i = 0; i < 1500; ++i)
            res = Math.min(res, Math.abs(sumA - dp[i] * i * 2));
        return res;
    }

    // Similar to 2
    public int lastStoneWeightII3(int[] stones) {
        boolean[][] dp = new boolean[stones.length + 1][3001];
        dp[0][0] = true;
        int tot = 0;
        for (int i = 0; i < stones.length; i++) {
            tot += stones[i];
            for (int j = 0; j <= 100 * i; ++j) {
                dp[i + 1][j] |= dp[i][j];
                dp[i + 1][j + stones[i]] |= dp[i][j];
            }
        }
        int ans = tot;
        for (int i = 0; i < tot; i++) {
            if (dp[stones.length][i])
                ans = Math.min(ans, Math.abs(i - (tot - i)));
        }
        return ans;
    }
}
