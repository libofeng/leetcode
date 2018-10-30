package com.leetcode.dp;

import java.util.Arrays;

public class No87ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if (!Arrays.equals(chars1, chars2)) return false;

        final int n = s1.length();
        for (int i = 1; i < n; i++) {
            String s11 = s1.substring(0, i), s12 = s1.substring(i, n);
            String s21 = s2.substring(0, i), s22 = s2.substring(i, n);

            if (isScramble(s11, s21) && isScramble(s12, s22)) return true;
            s21 = s2.substring(n - s11.length(), n);
            s22 = s2.substring(0, s12.length());
            if (isScramble(s11, s21) && isScramble(s12, s22)) return true;
        }

        return false;
    }

    public boolean isScramble2(String s1, String s2) {
        final int n = s1.length();
        final boolean[][][] dp = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    for (int k = 1; k < len; k++) {
                        if ((dp[i][j][k] && dp[i + k][j + k][len - k])
                                || (dp[i + k][j][len - k] && dp[i][j + len - k][k])) dp[i][j][len] = true;
                    }
                }
            }
        }

        return dp[0][0][n];
    }
}
