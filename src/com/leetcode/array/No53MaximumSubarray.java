package com.leetcode.array;

public class No53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int n : nums) {
            if (sum <= 0) sum = n;
            else sum += n;

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
