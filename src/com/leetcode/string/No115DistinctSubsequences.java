package com.leetcode.string;

public class No115DistinctSubsequences {

    // --------------------------
    // BackTracking(TLE)
    private int count = 0;

    public int numDistinct2(String s, String t) {
        helper(s, t, 0, 0);
        return count;
    }

    private void helper(String s, String t, int i, int j) {
        if (j == t.length()) {
            count++;
            return;
        } else if (i == s.length()) return;

        for (int k = i; k < s.length(); k++) if (s.charAt(k) == t.charAt(j)) helper(s, t, k + 1, j + 1);
    }

    // DP
    // https://leetcode.com/problems/distinct-subsequences/discuss/37327/Easy-to-understand-DP-in-Java

    // https://www.programcreek.com/2013/01/leetcode-distinct-subsequences-total-java/
    // "When you see string problem that is about subsequence or matching,
    // dynamic programming method should come to mind naturally. "

    public int numDistinct(String s, String t) {
        final int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = 1;
        for (int j = 1; j <= n; j++) dp[0][j] = 0;

        for (int j = 1; j <= n; j++) {
            for (int i = j; i <= m; i++) {
                dp[i][j] = s.charAt(i - 1) == t.charAt(j - 1) ? (dp[i - 1][j] + dp[i - 1][j - 1]) : dp[i - 1][j];
            }
        }

        return dp[m][n];
    }
}
