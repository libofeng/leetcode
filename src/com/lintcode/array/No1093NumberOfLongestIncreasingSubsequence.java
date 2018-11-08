package com.lintcode.array;

import java.util.Arrays;

public class No1093NumberOfLongestIncreasingSubsequence {
    /**
     * @param nums: an array
     * @return: the number of longest increasing subsequence
     */
    public int findNumberOfLIS(int[] nums) {
        final int[] LIS = new int[nums.length], CNT = new int[nums.length];
        Arrays.fill(LIS, 1);
        Arrays.fill(CNT, 1);

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] <= nums[j]) continue;

                if (LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                    CNT[i] = CNT[j];
                } else if (LIS[i] == LIS[j] + 1) CNT[i] += CNT[j];
            }

            max = Math.max(max, LIS[i]);
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) if (LIS[i] == max) count += CNT[i];
        return count;
    }
}
