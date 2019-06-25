package com.leetcode.array;

import java.util.Arrays;

public class No280WiggleSort {
    // https://www.cnblogs.com/grandyang/p/5177285.html
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) swap(nums, i, i + 1);
    }

    public void wiggleSort2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int mod = (i & 1);
            if((mod == 1 && nums[i]<nums[i-1]) || (mod == 0 && nums[i]>nums[i-1])) swap(nums, i-1, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
