package com.leetcode.string;

public class No647PalindromicSubstrings {
    private int count;

    // Time: N(N^2) Space: O(1)
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return count;
    }

    private void expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i--) == s.charAt(j++)) count++;
    }

    // Time: N(N^2) Space: O(N^2)
    public int countSubstrings2(String s) {
        final int n = s.length();
        int count = 0;
        final boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || dp[j + 1][i - 1])) {
                    count++;
                    dp[j][i] = true;
                }
            }
        }

        return count;
    }
}
