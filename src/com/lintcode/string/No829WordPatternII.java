package com.lintcode.string;

import java.util.HashMap;
import java.util.Map;

public class No829WordPatternII {
    /**
     * @param pattern: a string,denote pattern string
     * @param str:     a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        return isMatch(pattern, 0, str, 0);
    }

    private Map<Character, String> ab = new HashMap<>();
    private Map<String, Character> ba = new HashMap<>();

    private boolean isMatch(String pattern, int i, String str, int j) {
        if (i == pattern.length()) return j == str.length();
        if (j == str.length()) return false;

        char p = pattern.charAt(i);
        if (ab.containsKey(p)) {
            String s = ab.get(p);
            if (!ba.containsKey(s) || ba.get(s) != p) return false;
            if (!str.substring(j).startsWith(s)) return false;

            return isMatch(pattern, i + 1, str, j + s.length());
        }

        for (int k = j; k < str.length(); k++) {
            String s = str.substring(j, k + 1);
            if (ba.containsKey(s)) return false;

            ab.put(p, s);
            ba.put(s, p);
            if (isMatch(pattern, i + 1, str, k + 1)) return true;
            ab.remove(p);
            ba.remove(s);
        }

        return false;
    }
}
