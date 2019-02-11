package com.leetcode.string;

public class No5LongestPalindromicSubstring {
    private int start = -1, end = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return s.substring(start + 1, end);
    }

    private void expand(String s, int lo, int hi) {
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }

        if (hi - lo > end - start) {
            start = lo;
            end = hi;
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
