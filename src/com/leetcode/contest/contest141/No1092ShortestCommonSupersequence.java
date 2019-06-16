package com.leetcode.contest.contest141;

public class No1092ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        String lcs = lcs(str1, str2);
        if (lcs.isEmpty()) return str1 + str2;

        int i = 0, j = 0;
        final StringBuilder sb = new StringBuilder();
        for (int k = 0; k < lcs.length() && i < str1.length() && j < str2.length(); k++) {
            char c = lcs.charAt(k);
            while (i < str1.length() && str1.charAt(i) != c) sb.append(str1.charAt(i++));
            while (j < str2.length() && str2.charAt(j) != c) sb.append(str2.charAt(j++));

            if (i < str1.length() && j < str2.length()) {
                sb.append(c);
                i++;
                j++;
            }
        }
        sb.append(str1.substring(i));
        sb.append(str2.substring(j));

        return sb.toString();
    }

    private String lcs(String a, String b) {
        final int m = a.length(), n = b.length();
        final int[][] dp = new int[m + 1][n + 1];

        int max = 0, x = 0, y = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

                if (dp[i][j] > max) {
                    max = dp[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        final StringBuilder sb = new StringBuilder();
        while (x > 0 && y > 0) {
            if (dp[x][y] == dp[x - 1][y]) x--;
            else if (dp[x][y] == dp[x][y - 1]) y--;
            else {
                sb.append(a.charAt(x - 1));
                x--;
                y--;
            }
        }

        return sb.reverse().toString();
    }
}
