package com.lintcode.string;

public class No837PalindromicSubstrings {
    /**
     * @param str: s string
     * @return: return an integer, denote the number of the palindromic substrings
     */
    public int countPalindromicSubstrings(String str) {
        int total = 0;
        final int len = str.length();
        final boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if (str.charAt(i) == str.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    total++;
                }
            }
        }

        return total;
    }

    // faster solution
    public int countPalindromicSubstrings2(String str) {
        int total = 0;
        for (int i = 0; i < str.length(); i++) total += count(str, i, i) + count(str, i, i + 1);

        return total;
    }

    private int count(String s, int i1, int i2) {
        int count = 0;
        while (i1 >= 0 && i2 < s.length() && s.charAt(i1--) == s.charAt(i2++)) count++;
        return count;
    }
}
