package com.leetcode.string;

import java.util.Arrays;

public class No3LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int[] positions = new int[128];
        Arrays.fill(positions, -1);

        int start = -1, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (positions[c] > start) start = positions[c];

            maxLen = Math.max(maxLen, i - start);
            positions[c] = i;
        }

        return maxLen;
    }
}
