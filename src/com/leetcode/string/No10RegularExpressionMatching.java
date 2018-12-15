package com.leetcode.string;

public class No10RegularExpressionMatching {
    // https://leetcode.com/articles/regular-expression-matching/
    // https://www.cnblogs.com/yrbbest/p/4430699.html
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean firstMatch = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) ||
                    (firstMatch && isMatch(text.substring(1), pattern)));
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public boolean isMatch2(String s, String p) {
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
