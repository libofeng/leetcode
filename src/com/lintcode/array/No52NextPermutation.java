package com.lintcode.array;

public class No52NextPermutation {
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        final int n = nums.length;
        int p = n - 2;
        for (; p >= 0; p--) if (nums[p] < nums[p + 1]) break;
        if (p < 0) {
            reverse(nums, 0, n - 1);
            return nums;
        }

        int q = n - 1;
        for (; q > p; q--) if (nums[q] > nums[p]) break;
        swap(nums, p, q);
        reverse(nums, p + 1, n - 1);

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) swap(nums, i++, j--);
    }
}
