package com.leetcode.contest.contest139;

public class No1071GreatestCommonDivisorOfStrings2 {
    public String gcdOfStrings(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        for (; len > 0; len--) {
            if (!isDivided(str1, len) || !isDivided(str2, len)) continue;

            String gcd = str1.substring(0, len);
            if (gcd.equals(str2.substring(0, len))) return gcd;
        }

        return "";
    }

    private boolean isDivided(String s, int k) {
        if (s.length() % k > 0) return false;
        for (int i = 0; i < s.length() - k; i++) {
            if (s.charAt(i) != s.charAt(i + k)) return false;
        }

        return true;
    }
}
