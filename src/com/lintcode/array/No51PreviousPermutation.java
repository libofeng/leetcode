package com.lintcode.array;

import java.util.List;

public class No51PreviousPermutation {
    /*
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public List<Integer> previousPermuation(List<Integer> nums) {
        int p = nums.size() - 2;
        for (; p >= 0; p--) if (nums.get(p) > nums.get(p + 1)) break;
        if (p < 0) {
            reverse(nums, 0, nums.size() - 1);
            return nums;
        }

        int q = nums.size() - 1;
        for (; q >= 0; q--) if (nums.get(p) > nums.get(q)) break;

        swap(nums, p, q);
        reverse(nums, p + 1, nums.size() - 1);

        return nums;
    }

    private void reverse(List<Integer> nums, int i, int j) {
        while (i < j) swap(nums, i++, j--);
    }

    private void swap(List<Integer> nums, int i, int j) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }
}
