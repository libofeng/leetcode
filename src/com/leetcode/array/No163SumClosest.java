package com.leetcode.array;

import java.util.Arrays;

public class No163SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int minGap = Integer.MAX_VALUE, minGapSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high], gap = Math.abs(target - sum);
                if (gap < minGap) {
                    minGapSum = sum;
                    minGap = gap;
                }

                if (sum > target) high--;
                else low++;
            }
        }

        return minGapSum;
    }
}
