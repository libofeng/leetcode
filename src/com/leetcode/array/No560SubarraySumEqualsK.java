package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class No560SubarraySumEqualsK {
    // 1. prefix sum: this is based on Kadane's Algorithm
    // 2. set initiative state 0:1, means there is 1 sum of 0

    public int subarraySum(int[] nums, int k) {
        final Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        int sum = 0, total = 0;
        for (int n : nums) {
            sum += n;
            total += sumMap.getOrDefault(sum - k, 0);
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }

        return total;
    }
}
