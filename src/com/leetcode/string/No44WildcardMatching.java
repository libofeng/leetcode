package com.leetcode.string;

public class No44WildcardMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int i, String p, int j) {
        if (i == s.length() && j == p.length()) return true;
        if (i == s.length() && p.charAt(j) == '*') return isMatch(s, i, p, j + 1);
        if (i == s.length() || j == p.length()) return false;

        if (p.charAt(j) == '*') {
            while (j < p.length() && p.charAt(j) == '*') j++;
            if (j == p.length()) return true;
            while (i < s.length() && !isMatch(s, i, p, j)) i++;
            return i < s.length();
        } else if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
            return isMatch(s, i + 1, p, j + 1);
        } else return false;
    }
}
