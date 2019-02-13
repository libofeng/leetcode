package com.leetcode.string;

public class No76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        final int[] counter = new int[128];
        for (int i = 0; i < t.length(); i++) counter[t.charAt(i)]++;

        int total = t.length(), minStart = 0, minLen = Integer.MAX_VALUE, start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (counter[s.charAt(i)]-- > 0) total--;

            while (total == 0) {
                if (i + 1 - start < minLen) {
                    minStart = start;
                    minLen = i + 1 - start;
                }
                if (counter[s.charAt(start++)]++ >= 0) total++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
