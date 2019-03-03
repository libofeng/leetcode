package com.leetcode.contest.contest126;

public class No1000MinimumCostToMergeStones {
    public int mergeStones(int[] a, int K) {
        int n = a.length;
        if (n % (K - 1) != 1 % (K - 1)) {
            return -1;
        }
        int[] cum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cum[i + 1] = cum[i] + a[i];
        }

        int[][] dp = new int[n][n];
        for (int len = K; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                int cost = Integer.MAX_VALUE;
                int ulen = (len - 1) / (K - 1) * (K - 1) + 1;
                if (ulen % (K - 1) == 1 % (K - 1)) {
                    ulen -= K - 1;
                }
                int s = len % (K - 1) == 1 % (K - 1) ? len - (K - 1) : len;
                for (int k = i + 1; k <= j; k++) {
                    if ((k - i - 1) / (K - 1) + (j - k + 1 - 1) / (K - 1) == (s - 1) / (K - 1)) {
                        int c = 0;
                        if (i <= k - 1) c += dp[i][k - 1];
                        if (k <= j) c += dp[k][j];
                        cost = Math.min(cost, c);
                    }
                }
                if (len % (K - 1) == 1 % (K - 1)) {
                    cost += cum[j + 1] - cum[i];
                }
                dp[i][j] = cost;
            }
        }
        return dp[0][n - 1];
    }
}
