package com.leetcode.array;

public class No80RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 2) return nums == null ? 0 : nums.length;

        int index = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index] || nums[i] != nums[index - 1]) nums[++index] = nums[i];
        }

        return index + 1;
    }
}
