package com.leetcode.string;

public class No482LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        final StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '-') continue;
            sb.append(sb.length() % (K + 1) == K ? "-" : "").append(S.charAt(i));
        }

        return sb.reverse().toString().toUpperCase();
    }
}
