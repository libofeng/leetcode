package com.leetcode.string;

public class No459RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        final int len = s.length();
        for (int i = 1; i <= len/2; i++) {
            if (s.charAt(i) == s.charAt(0)) {
                if (len % (i) > 0) continue;
                if (verifyRepeat(s, s.substring(0, i))) return true;
            }
        }

        return false;
    }

    private boolean verifyRepeat(String s, String repeat) {
        for (int i = 0; i < s.length(); i += repeat.length()) {
            for (int j = 0; j < repeat.length(); j++) if (s.charAt(i + j) != repeat.charAt(j)) return false;
        }
        return true;
    }
}
