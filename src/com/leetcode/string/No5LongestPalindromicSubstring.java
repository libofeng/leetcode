package com.leetcode.string;

public class No5LongestPalindromicSubstring {
    int maxLen = 1, start = 0;

    public String longestPalindrome(String s) {
        final int len = s.length();
        if (len <= 1) return s;

        for (int i = 0; i < len; i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }

        return s.substring(start, start + maxLen);
    }

    private void expand(String s, int i1, int i2) {
        while (i1 >= 0 && i2 < s.length() && s.charAt(i1) == s.charAt(i2)) {
            if (i2 - i1 + 1 > maxLen) {
                maxLen = i2 - i1 + 1;
                start = i1;
            }
            i1--;
            i2++;
        }
    }

    public String longestPalindrome2(String s) {
        final int len = s.length();
        if (len <= 1) return s;
        final boolean[][] valid = new boolean[len][len];

        int maxLen = 1, start = 0;
        for (int i = 0; i < len; i++) {
            valid[i][i] = true;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == s.charAt(i) && (valid[j + 1][i - 1] || i - j <= 1)) valid[j][i] = true;
                if (valid[j][i] && (i - j + 1) > maxLen) {
                    start = j;
                    maxLen = i - j + 1;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}
