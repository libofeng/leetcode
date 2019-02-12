package com.leetcode.array;

public class No31NextPermutation {
    public void nextPermutation(int[] nums) {
        final int n = nums.length;
        int dropIndex = -1;
        for(int i = n-2;i>=0 && dropIndex<0;i--) if(nums[i]<nums[i+1]) dropIndex = i;
        if(dropIndex==-1){
            reverse(nums, 0, n-1);
            return;
        }

        int exchangeIndex = -1;
        for(int i = n-1;i>dropIndex && exchangeIndex<0;i--) if(nums[i]>nums[dropIndex]) exchangeIndex = i;
        swap(nums, dropIndex, exchangeIndex);
        reverse(nums, dropIndex+1, n-1);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j){
        while(i<j) swap(nums, i++, j--);
    }
}
