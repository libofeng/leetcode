package com.lintcode.math;

import java.util.Arrays;

public class No818SubsetWithTarget {
    /**
     * @param nums:   the array
     * @param target: the target
     * @return: the number of subsets which meet the following conditions
     */
    public long subsetWithTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        long count = 0;
        while (l <= r) {
            if (nums[l] + nums[r] < target) {
                count += (long) Math.pow(2, (r - l));
                // since will update l to l+1, the subset must contains nums[l]
                // others number will have the option: include or exclude
                l++;
            } else {
                r--;
            }
        }

        return count;
    }
}
