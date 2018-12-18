package com.lintcode.string;

public class No154RegularExpressionMatching {
    /**
     * @param s: A string
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private boolean matchFirst(String s, int i, String p, int j) {
        if (i == s.length()) return j == p.length();
        if (j == p.length()) return i == s.length();

        return s.charAt(i) == p.charAt(j) || '.' == p.charAt(j);
    }

    private boolean isMatch(String s, int i, String p, int j) {
        if (j == p.length()) return i == s.length();

        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            if (isMatch(s, i, p, j + 2)) return true;
            while (matchFirst(s, i, p, j)) if (isMatch(s, ++i, p, j + 2)) return true;
            return false;
        }

        return matchFirst(s, i, p, j) && isMatch(s, i + 1, p, j + 1);
    }

    public boolean isMatch2(String s, String p) {
        final int m = s.length(), n = p.length();
        final boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j > 1 && p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                } else {
                    dp[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
