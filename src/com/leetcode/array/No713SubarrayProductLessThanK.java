package com.leetcode.array;

public class No713SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0, count = 0, product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (product >= k && start <= i) product /= nums[start++];
            count += i - start + 1;
        }

        return count;
    }
}
