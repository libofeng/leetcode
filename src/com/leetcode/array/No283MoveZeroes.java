package com.leetcode.array;

public class No283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] != 0) nums[index++] = nums[i];
        }

        for (int i = index; i < nums.length; i++) nums[i] = 0;
    }
}
