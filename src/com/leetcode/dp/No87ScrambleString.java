package com.leetcode.dp;

public class No87ScrambleString {
    // Time: O(4^N) Space: O(N^2)
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        final int[] counter = new int[26];
        for (int i = 0; i < s1.length(); i++) counter[s1.charAt(i) - 'a']++;
        for (int i = 0; i < s2.length(); i++) if (counter[s2.charAt(i) - 'a']-- == 0) return false;

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) return true;

            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) return true;
        }

        return false;
    }

    // https://leetcode.com/problems/scramble-string/discuss/29396/Simple-iterative-DP-Java-solution-with-explanation
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
