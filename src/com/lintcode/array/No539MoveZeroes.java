package com.lintcode.array;

public class No539MoveZeroes {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0, idx = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[idx++] = nums[i];
            if (i >= idx) nums[i] = 0;
        }
    }
}
