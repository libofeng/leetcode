package com.leetcode.contest.biweekly.contest4;

import java.util.HashMap;
import java.util.Map;

public class No1121DivideArrayIntoIncreasingSequences {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        final Map<Integer, Integer> count = new HashMap<>();
        int maxCount = 0;
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
            maxCount = Math.max(maxCount, count.get(n));
        }

        return nums.length / maxCount >= K;
    }
}
