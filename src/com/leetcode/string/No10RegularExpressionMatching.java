package com.leetcode.string;

public class No10RegularExpressionMatching {
    // https://leetcode.com/articles/regular-expression-matching/
    // https://www.cnblogs.com/yrbbest/p/4430699.html
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();

        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || '.' == p.charAt(0));
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        }

        return firstMatch && isMatch(s.substring(1), p.substring(1));
    }

    public boolean isMatch2(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private boolean matchFirst(String s, int i, String p, int j) {
        if (j == p.length()) return i == s.length();

        return i < s.length() && (s.charAt(i) == p.charAt(j) || '.' == p.charAt(j));
    }

    private boolean isMatch(String s, int i, String p, int j) {
        if (j == p.length()) return i == s.length();

        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
            return matchFirst(s, i, p, j) && isMatch(s, i + 1, p, j + 1);
        }

        if (isMatch(s, i, p, j + 2)) return true;
        while (matchFirst(s, i, p, j)) if (isMatch(s, ++i, p, j + 2)) return true;
        return false;
    }


    // DP
    public boolean isMatch3(String s, String p) {
        final int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j > 1 && p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (i > 0 && dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || '.' == p.charAt(j - 2)));
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || '.' == p.charAt(j - 1));
                }
            }
        }

        return dp[m][n];
    }
}
