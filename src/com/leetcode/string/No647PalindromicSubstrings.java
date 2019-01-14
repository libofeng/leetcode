package com.leetcode.string;

public class No647PalindromicSubstrings {
    int count;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return count;
    }

    private void expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i--) == s.charAt(j++)) count++;
    }
}
