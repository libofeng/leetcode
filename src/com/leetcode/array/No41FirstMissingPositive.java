package com.leetcode.array;

public class No41FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ) {
            if (nums[i] <= 0 || nums[i] > n || nums[i] == i + 1) i++;
            else {
                int j = nums[i] - 1;
                if (nums[i] == nums[j]) nums[i++] = 0;
                else swap(nums, i, j);
            }
        }

        for (int i = 0; i < n; i++) if (nums[i] != i + 1) return i + 1;
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
