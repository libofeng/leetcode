package com.lintcode.array;

import java.util.HashMap;
import java.util.Map;

public class No994ContiguousArray {

    /**
     * @param nums: a binary array
     * @return: the maximum length of a contiguous subarray
     */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int zeros = 0, ones = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) ones++;
            else zeros++;
            int target = zeros - ones;
            if (map.containsKey(target)) max = Math.max(max, i - map.get(target));

            map.putIfAbsent(target, i);
        }

        return max;
    }

}
