package com.lintcode.array;

public class No1310ProductOfArrayExceptSelf {
    /**
     * @param nums: an array of integers
     * @return: the product of all the elements of nums except nums[i].
     */
    public int[] productExceptSelf(int[] nums) {
        final int[] l = new int[nums.length];
        l[0] = 1;
        for (int i = 1; i < nums.length; i++) l[i] = l[i - 1] * nums[i - 1];

        for (int i = l.length - 1, right = 1; i >= 0; right *= nums[i--]) l[i] *= right;
        return l;
    }
}
