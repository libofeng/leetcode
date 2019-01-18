package com.leetcode.array;

public class No283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] != 0) nums[index++] = nums[i];
        }

        for (int i = index; i < nums.length; i++) nums[i] = 0;
    }


    // Minimize the total number of operations.
    public void moveZeroes2(int[] nums) {
        int index = 0;
        while(index<nums.length && nums[index]!=0) index++;
        for(int i = index+1; i<nums.length; i++) if(nums[i]!= 0) nums[index++] = nums[i];
        while(index<nums.length) nums[index++] = 0;
    }
}
