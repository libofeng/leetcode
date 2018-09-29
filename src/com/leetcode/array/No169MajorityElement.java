package com.leetcode.array;

import java.util.Arrays;

public class No169MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        int R = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                R = num;
                count++;
            } else if (R == num) {
                count++;
            } else {
                count--;
            }
        }

        return R;
    }
}
