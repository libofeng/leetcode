package com.lintcode.array;

import java.util.HashSet;
import java.util.Set;

public class No124LongestConsecutiveSequence {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        if (num.length < 2) return num.length;
        Set<Integer> set = new HashSet<>();
        for (int n : num) set.add(n);

        int maxLen = 1;
        for (int n : num) {
            if (!set.contains(n)) continue;
            int left = n, right = n;

            while (set.contains(left - 1)) set.remove(--left);
            while (set.contains(right + 1)) set.remove(++right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
