package com.leetcode.array;

public class No31NextPermutation {
    public void nextPermutation(int[] nums) {
        int partitionIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                partitionIndex = i;
                break;
            }
        }

        if (partitionIndex < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int exchangeIndex = 0;
        for (int i = nums.length - 1; i > partitionIndex; i--) {
            if (nums[i] > nums[partitionIndex]) {
                exchangeIndex = i;
                break;
            }
        }

        swap(nums, partitionIndex, exchangeIndex);
        reverse(nums, partitionIndex + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int low, int high) {
        while (low < high) swap(nums, low++, high--);
    }
}
