package com.leetcode.dp;

public class No97InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return helper(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0);
    }

    private boolean helper(char[] c1, int i1, char[] c2, int i2, char[] c3, int i3) {
        final int n1 = c1.length, n2 = c2.length, n3 = c3.length;
        if (i1 == n1 && i2 == n2 && i3 == n3) return true;

        if (i1 < n1 && c1[i1] == c3[i3] && i2 < n2 && c2[i2] == c3[i3])
            return helper(c1, i1 + 1, c2, i2, c3, i3 + 1) || helper(c1, i1, c2, i2 + 1, c3, i3 + 1);
        else if (i1 < n1 && c1[i1] == c3[i3]) return helper(c1, i1 + 1, c2, i2, c3, i3 + 1);
        else if (i2 < n2 && c2[i2] == c3[i3]) return helper(c1, i1, c2, i2 + 1, c3, i3 + 1);

        return false;
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        final int m = s1.length(), n = s2.length(), o = s3.length();
        if (m + n != o) return false;

        final boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        for (int j = 1; j <= n; j++) dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[m][n];
    }
}
