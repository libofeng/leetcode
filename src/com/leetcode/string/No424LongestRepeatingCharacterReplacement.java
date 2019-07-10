package com.leetcode.string;

public class No424LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        final int n = s.length();
        final int[] counter = new int[128];

        int start = -1, maxLen = 0, maxCount = 0;
        for (int i = 0; i < n; i++) {
            maxCount = Math.max(maxCount, ++counter[s.charAt(i)]);
            if (maxCount + k < i - start) counter[s.charAt(++start)]--;
            maxLen = Math.max(maxLen, i - start);
        }

        return maxLen;
    }
}
