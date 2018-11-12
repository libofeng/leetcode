package com.lintcode.string;

public class No192WildcardMatching {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        final int[][] cache = new int[s.length()][p.length()];
        return isMath(s, p, 0, 0, cache);
    }

    private boolean isMath(String s, String p, int i, int j, int[][] cache) {
        if (i == s.length() && j == p.length()) return true;
        if (i == s.length()) {
            while (j < p.length()) if (p.charAt(j++) != '*') return false;
            return true;
        } else if (j == p.length()) return false;

        if (cache[i][j] > 0) return cache[i][j] == 1;
        boolean match = false;
        if (s.charAt(i) == p.charAt(j)) match = isMath(s, p, i + 1, j + 1, cache);
        else if ('?' == p.charAt(j)) match = isMath(s, p, i + 1, j + 1, cache);
        else if ('*' == p.charAt(j))
            match = isMath(s, p, i, j + 1, cache) || isMath(s, p, i + 1, j, cache) || isMath(s, p, i + 1, j + 1, cache);
        cache[i][j] = match ? 1 : 2;
        return match;
    }

    // DP
    public boolean isMatch2(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= p.length(); i++) if (p.charAt(i - 1) == '*') dp[i][0] |= dp[i - 1][0];

        for (int i = 1; i <= p.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] |= dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    dp[i][j] |= dp[i - 1][j - 1] | dp[i][j - 1] | dp[i - 1][j];
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
