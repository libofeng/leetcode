package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class No560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        int sum = 0, total = 0;
        for (int n : nums) {
            sum += n;
            int targetSum = sum - k;
            if (sumMap.containsKey(targetSum)) total += sumMap.get(targetSum);
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }

        return total;
    }
}
