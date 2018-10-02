package com.leetcode.string;

public class No647PalindromicSubstrings {
    int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }

        return count;
    }

    private void expand(String s, int i1, int i2) {
        while (i1 >= 0 && i2 < s.length() && s.charAt(i1) == s.charAt(i2)) {
            count++;

            i2++;
            i1--;
        }
    }
}
