package com.leetcode.string;

public class No516LongestPalindromicSubsequence {
    // TLE, even improved to use a memorized solution
    public int longestPalindromeSubseq(String s) {
        final int n = s.length();
        if (n <= 1) return n;

        if (s.charAt(0) == s.charAt(n - 1)) {
            // O(N)
            return 2 + longestPalindromeSubseq(s.substring(1, n - 1));
        }

        // O(2^N)
        int r1 = longestPalindromeSubseq(s.substring(0, n - 1));
        int r2 = longestPalindromeSubseq(s.substring(1));
        return Math.max(r1, r2);
    }

    // O(N^2)
    public int longestPalindromeSubseq2(String s) {
        final int n = s.length();
        if (n <= 1) return n;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = i - j > 1 ? (dp[j + 1][i - 1] + 2) : (i - j + 1);
                } else dp[j][i] = i - j == 1 ? 1 : Math.max(dp[j + 1][i], dp[j][i - 1]);
            }
        }

        return dp[0][n - 1];
    }


    public int longestPalindromeSubseq3(String s) {

        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) dp[i][i] = 1;

        return helper(s, dp, 0, s.length() - 1);
    }

    private int helper(String s, int[][] dp, int i, int j) {
        if (j < i || dp[i][j] > 0) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) dp[i][j] = helper(s, dp, i + 1, j - 1) + 2;
        else dp[i][j] = Math.max(helper(s, dp, i + 1, j), helper(s, dp, i, j - 1));
        return dp[i][j];
    }
}
