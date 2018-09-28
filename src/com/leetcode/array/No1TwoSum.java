package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class No1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] R = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    R[0] = i;
                    R[1] = j;
                    break;
                }
            }
        }

        return R;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] R = new int[2];
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num) && map.get(num) != i) {
                R[0] = i;
                R[1] = map.get(num);
            }
        }

        return R;
    }
}
