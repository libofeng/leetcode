package com.leetcode.contest.contest137;

import java.util.Arrays;

public class No1048LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        final int n = words.length;
        final int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    private boolean isPredecessor(String a, String b) {
        if (a.length() + 1 != b.length()) return false;

        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            char c1 = a.charAt(i), c2 = b.charAt(j);
            if (c1 == c2) i++;

            j++;
        }

        return i == a.length();
    }
}
