package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class No525ContiguousArray {

    public int findMaxLength(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int max = 0, ones = 0, zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros++;
            else ones++;

            int diff = ones - zeros;
            if (map.containsKey(diff)) max = Math.max(max, i - map.get(diff));
            else map.put(diff, i);
        }

        return max;
    }
}
