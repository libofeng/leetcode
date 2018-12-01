package com.lintcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No523ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <= 1) return false;

        Set<Integer> set = new HashSet<>(Arrays.asList(0, nums[0]));
        for (int i = 1, sum = nums[0]; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0 && !set.add(sum % k)) return true;
            if (k == 0 && nums[i] == 0 && nums[i - 1] == 0) return true;
        }

        return false;
    }
}
