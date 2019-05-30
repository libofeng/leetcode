package com.leetcode.string;

import java.util.Arrays;

public class No395LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        No395LongestSubstringWithAtLeastKRepeatingCharacters solution = new No395LongestSubstringWithAtLeastKRepeatingCharacters();
        int maxLen = solution.longestSubstring("aaabb", 3);
        System.out.println("maxLen = " + maxLen);
    }

    public int longestSubstring(String s, int k) {
        final int n = s.length();
        final int[] counter = new int[26];

        int maxLen = 0;
        for (int h = 1; h <= 26; h++) {
            Arrays.fill(counter, 0);
            int i = 0, j = 0, unique = 0, leastK = 0;
            while (j < n) {
                if (unique <= h) {
                    int count = ++counter[s.charAt(j++) - 'a'];
                    if (count == 1) unique++;
                    if (count == k) leastK++;
                } else {
                    int count = --counter[s.charAt(i++) - 'a'];
                    if (count == 0) unique--;
                    if (count == k - 1) leastK--;
                }

                if (unique == leastK) maxLen = Math.max(maxLen, j - i);
            }
        }

        return maxLen;
    }
}
