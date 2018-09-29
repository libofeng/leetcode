package com.leetcode.array;

public class No189RotateArray {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int tmp = nums[nums.length - 1];
            if (nums.length - 1 >= 0) System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = tmp;
        }
    }

    // using 3 flips
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;
        k = k % nums.length;

        swap(nums, 0, nums.length - k - 1);
        swap(nums, nums.length - k, nums.length - 1);
        swap(nums, 0, nums.length - 1);
    }

    private void swap(int[] nums, int low, int high) {
        while (low < high) {
            int tmp = nums[low];
            nums[low++] = nums[high];
            nums[high--] = tmp;
        }
    }
}
