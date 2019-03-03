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

    public int mergeStones2(int[] stones, int K) {
        int n = stones.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + stones[i - 1];
        }
        int[][][] dp = new int[205][205][205];
        int INF = 1000000000;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    dp[i][j][k] = INF;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            dp[i][i][1] = 0;
        }
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                for (int k = 2; k <= len; k++) {
                    for (int t = i; t + 1 <= j; t++) {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][t][k - 1] + dp[t + 1][j][1]);
                    }
                }

                dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j][K] + pre[j] - pre[i - 1]);
            }
        }


        if (dp[1][n][1] >= INF) {
            return -1;
        }
        return dp[1][n][1];
    }
}
