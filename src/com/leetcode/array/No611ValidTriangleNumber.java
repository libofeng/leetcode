package com.leetcode.array;

import java.util.Arrays;

public class No611ValidTriangleNumber {
    // Time: O(N^2)
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int lo = 0, hi = i - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] <= nums[i]) lo++;
                else {
                    count += hi - lo;
                    hi--;
                }
            }
        }

        return count;
    }
}
