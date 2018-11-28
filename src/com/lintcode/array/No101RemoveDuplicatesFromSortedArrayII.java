package com.lintcode.array;

public class No101RemoveDuplicatesFromSortedArrayII {
    /**
     * @param nums: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 1] || nums[i] != nums[index - 2]) nums[index++] = nums[i];
        }

        return index;
    }
}
