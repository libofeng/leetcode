package com.lintcode.array;

import java.util.HashMap;
import java.util.Map;

public class No911MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] += sums[i - 1] + nums[i - 1];
        int max = 0;
        for (int i = 1; i < sums.length; i++) {
            for (int j = i; j > 0; j--) if (sums[i] - sums[j - 1] == k) max = Math.max(max, i - j + 1);
        }

        return max;
    }

    public int maxSubArrayLen2(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int target = sum - k;
            if (map.containsKey(target)) max = Math.max(max, i - map.get(target));
            map.putIfAbsent(sum, i);
        }

        return max;
    }
}
