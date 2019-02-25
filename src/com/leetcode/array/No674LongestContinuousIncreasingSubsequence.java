package com.leetcode.array;

public class No674LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = 1, maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                len++;
                maxLen = Math.max(maxLen, len);
            } else len = 1;
        }

        return maxLen;
    }
}
