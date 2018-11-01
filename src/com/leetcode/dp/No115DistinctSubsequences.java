package com.leetcode.dp;

public class No115DistinctSubsequences {
    private int count = 0;
    public int numDistinct(String s, String t) {
        helper(s, t, "", 0);
        return count;
    }

    private void helper(String s, String t, String path, int start){
        if(path.length() >= t.length()){
            if(path.equals(t)) count++;
            return;
        }else if(!t.startsWith(path)) return;

        for(int i = start; i<s.length(); i++) helper(s, t, path + s.charAt(i), i + 1);
    }

    public int numDistinct2(String s, String t) {
        if (s.length() < t.length()) return 0;
        final int m = s.length(), n = t.length();
        final int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = 1;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] += dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] += dp[i - 1][j - 1];
            }
        }

        return dp[m][n];
    }

    // simplified from numDistinct2
    public int numDistinct3(String s, String t) {
        if (s.length() < t.length()) return 0;
        final int m = s.length(), n = t.length();
        final int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i < m + 1; i++) {
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[j] += dp[j - 1];
            }
        }

        return dp[n];
    }
}
