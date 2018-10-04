package com.leetcode.string;

public class No10RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private boolean matchFirst(String s, int i, String p, int j) {
        if (i == s.length()) return j == p.length();
        if (j == p.length()) return i == s.length();

        return s.charAt(i) == p.charAt(j) || '.' == p.charAt(j);
    }

    private boolean isMatch(String s, int i, String p, int j) {
        if (j == p.length()) return i == s.length();

        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
            if (matchFirst(s, i, p, j)) return isMatch(s, i + 1, p, j + 1);
            else return false;
        } else {
            if (isMatch(s, i, p, j + 2)) return true;
            while (matchFirst(s, i, p, j)) if (isMatch(s, ++i, p, j + 2)) return true;
            return false;
        }
    }
}
