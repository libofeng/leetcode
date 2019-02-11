package com.leetcode.array;

public class No53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for(int n : nums){
            sum = n + Math.max(sum, 0);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
