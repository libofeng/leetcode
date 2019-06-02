package com.leetcode.contest.contest139;

public class No1071GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (canBuild(str1, str2)) return str2;

        for (int i = str2.length() / 2; i > 0; i--) {
            if (str2.length() % i > 0) continue;

            String gcd = str2.substring(0, i);
            if (canBuild(str1, gcd) && canBuild(str2, gcd)) return gcd;
        }

        return "";
    }

    // s2 can build s1
    private boolean canBuild(String s1, String s2) {
        int i = 0, j = 0;
        for (; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(j)) break;
            j = ++j % s2.length();
        }

        return i == s1.length() && j == 0;
    }
}
