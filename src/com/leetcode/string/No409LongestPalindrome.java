package com.leetcode.string;

public class No409LongestPalindrome {
    public int longestPalindrome(String s) {
        int len = 0;
        final int[] counter = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (++counter[c] == 2) {
                len += 2;
                counter[c] = 0;
            }
        }

        return len < s.length() ? (len + 1) : len;
    }
}
