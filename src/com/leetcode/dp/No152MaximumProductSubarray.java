package com.leetcode.dp;

public class No152MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int[] dpMin = new int[nums.length], dpMax = new int[nums.length];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        int maxProduct = dpMax[0];

        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMin[i - 1] * nums[i], Math.max(nums[i] * dpMax[i - 1], nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(nums[i] * dpMax[i - 1], nums[i]));
            maxProduct = Math.max(dpMax[i], maxProduct);
        }

        return maxProduct;
    }


    public int maxProduct2(int[] nums) {
        int min = nums[0], max = min, maxProduct = min;

        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(min * nums[i], Math.max(nums[i] * max, nums[i]));
            min = Math.min(min * nums[i], Math.min(nums[i] * tmp, nums[i]));
            maxProduct = Math.max(max, maxProduct);
        }

        return maxProduct;
    }
}
