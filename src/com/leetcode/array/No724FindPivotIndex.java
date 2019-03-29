package com.leetcode.array;

public class No724FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int n : nums) totalSum += n;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 + nums[i] == totalSum) return i;
            sum += nums[i];
        }

        return -1;
    }
}
