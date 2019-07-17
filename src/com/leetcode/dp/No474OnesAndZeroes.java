package com.leetcode.dp;

public class No474OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        final int l = strs.length;
        final int[][][] dp = new int[l + 1][m + 1][n + 1];

        for (int i = 1; i < l + 1; i++) {
            final int[] count = new int[2];
            for (char c : strs[i - 1].toCharArray()) count[c - '0']++;

            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (j >= count[0] && k >= count[1]) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - count[0]][k - count[1]] + 1);
                    } else dp[i][j][k] = dp[i - 1][j][k];
                }
            }
        }

        return dp[l][m][n];
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        final int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            final int[] d = new int[2];
            for (char c : s.toCharArray()) d[c - '0']++;

            for (int j = m; j >= d[0]; j--) {
                for (int k = n; k >= d[1]; k--) dp[j][k] = Math.max(dp[j][k], dp[j - d[0]][k - d[1]] + 1);
            }
        }

        return dp[m][n];
    }
}
