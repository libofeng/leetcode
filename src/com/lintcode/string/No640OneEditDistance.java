package com.lintcode.string;

public class No640OneEditDistance {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() > t.length()) return isOneEditDistance(t, s);
        if (t.length() - s.length() > 1) return false;
        if (s.equals(t)) return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() != t.length()) {
                    return s.substring(i).equals(t.substring(i + 1));
                } else {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
            }
        }

        return true;
    }

    // is the same idea as the solution above
    public boolean isOneEditDistance2(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        if (s.equals(t)) return false;

        if (s.length() == t.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
            }

            return false;
        } else {
            int minLen = Math.min(s.length(), t.length());
            for (int i = 0; i < minLen; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (s.length() < t.length()) {
                        return s.substring(i).equals(t.substring(i + 1));
                    } else {
                        return s.substring(i + 1).equals(t.substring(i));
                    }
                }
            }

            return true;
        }
    }
}
