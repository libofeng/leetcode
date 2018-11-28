package com.lintcode.array;

public class No100RemoveDuplicatesFromSortedArray {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        int p = 1;
        for (int i = 0; i < n; i++) if (nums[i] != nums[p - 1]) nums[p++] = nums[i];
        return p;
    }
}
