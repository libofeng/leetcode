package com.lintcode.string;

public class No32MinimumWindowSubstring {
    /**
     * @param source  : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        int minIndex = 0, min = Integer.MAX_VALUE;
        final int[] count = new int[128];
        final char[] s = source.toCharArray(), t = target.toCharArray();
        for (char c : t) count[c]++;

        int left = 0, total = t.length;
        for (int i = 0; i < s.length; i++) {
            if (count[s[i]]-- > 0) total--;

            while (total == 0) {
                if (min > i - left + 1) {
                    min = i - left + 1;
                    minIndex = left;
                }
                if (count[s[left++]]++ >= 0) total++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : source.substring(minIndex, minIndex + min);
    }
}
