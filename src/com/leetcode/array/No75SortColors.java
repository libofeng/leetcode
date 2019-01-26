package com.leetcode.array;

public class No75SortColors {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, index = left;
        while (index <= right) {
            if (nums[index] == 1) index++;
            else if (nums[index] == 0) swap(nums, left++, index++);
            else swap(nums, index, right--);
        }
    }


    public void sortColors2(int[] nums) {
        partition(nums, 1);
        partition(nums, 2);
    }

    private void partition(int[] nums, int pivot) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] < pivot) left++;
            else swap(nums, left, right--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
