package com.lintcode.string;

public class No77LongestCommonSubsequence {

    public int longestCommonSubsequence(String A, String B) {
        if (A.isEmpty() || B.isEmpty()) return 0;
        if (A.charAt(0) == B.charAt(0)) return 1 + longestCommonSubsequence(A.substring(1), B.substring(1));

        int a = longestCommonSubsequence(A, B.substring(1)), b = longestCommonSubsequence(A.substring(1), B);
        return Math.max(a, b);
    }


    public int longestCommonSubsequence2(String A, String B) {
        if (A.isEmpty() || B.isEmpty()) return 0;
        int[][] dp = new int[A.length()][B.length()];
        return helper(A, B, dp, 0, 0);
    }

    private int helper(String A, String B, int[][] dp, int i, int j) {
        if (i == A.length() || j == B.length()) return 0;
        if (dp[i][j] > 0) return dp[i][j];

        if (A.charAt(i) == B.charAt(j)) dp[i][j] = 1 + helper(A, B, dp, i + 1, j + 1);
        else {
            int a = helper(A, B, dp, i, j + 1), b = helper(A, B, dp, i + 1, j);
            dp[i][j] = Math.max(a, b);
        }

        return dp[i][j];
    }

    public int longestCommonSubsequence3(String A, String B) {
        if (A.isEmpty() || B.isEmpty()) return 0;
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = A.length() - 1; i >= 0; i--) {
            for (int j = B.length() - 1; j >= 0; j--) {
                if (A.charAt(i) == B.charAt(j)) dp[i][j] = dp[i + 1][j + 1] + 1;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}
