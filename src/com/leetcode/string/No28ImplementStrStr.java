package com.leetcode.string;

public class No28ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0 || haystack.length() < needle.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j;
                for (j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                }
                if (j == needle.length()) return i;
            }
        }

        return -1;
    }

    // ------------- KMP ---------------

    private int[] next(String pattern) {
        final int[] next = new int[pattern.length()];
        for (int i = 1, j = 0; i < next.length; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) j = next[j - 1];
            next[i] = pattern.charAt(i) == pattern.charAt(j) ? ++j : j;
        }

        return next;
    }

    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        final int[] next = next(needle);

        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) j = next[j - 1];
            if (haystack.charAt(i) == needle.charAt(j) && ++j == needle.length()) return i + 1 - j;
        }

        return -1;
    }
}
