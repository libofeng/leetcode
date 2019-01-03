package com.lintcode.string;

public class No762LongestCommonSubsequenceII {
    /**
     * @param P: an integer array P
     * @param Q: an integer array Q
     * @param k: the number of allowed changes
     * @return: the length of lca with at most k changes allowed.
     */
    public int longestCommonSubsequenceTwo(int[] P, int[] Q, int k) {
        if (P.length == 0 || Q.length == 0) return 0;
        int[][][] dp = new int[P.length + 1][Q.length + 1][k + 1];
        for (int i = 1; i <= P.length; i++) {
            for (int j = 1; j <= Q.length; j++) {
                if (P[i - 1] == Q[j - 1]) dp[i][j][0] = 1 + dp[i - 1][j - 1][0];
                else dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]);
            }
        }

        if (k == 0) return dp[P.length][Q.length][0];
        for (int i = 1; i <= P.length; i++) {
            for (int j = 1; j <= Q.length; j++) {
                for (int l = 1; l <= k; l++) {
                    if (P[i - 1] == Q[j - 1]) {
                        dp[i][j][l] = Math.max(Math.max(dp[i - 1][j][l], dp[i][j - 1][l]), 1 + dp[i - 1][j - 1][l]);
                    } else {
                        dp[i][j][l] = Math.max(Math.max(dp[i - 1][j][l], dp[i][j - 1][l]), dp[i - 1][j - 1][l - 1] + 1);
                    }
                }
            }
        }

        return dp[P.length][Q.length][k];
    }
}
