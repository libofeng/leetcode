package com.lintcode.array;

public class No1310ProductOfArrayExceptSelf {
    /**
     * @param nums: an array of integers
     * @return: the product of all the elements of nums except nums[i].
     */
    public int[] productExceptSelf(int[] nums) {
        final int[] p = new int[nums.length];
        p[0] = nums[0];
        for (int i = 1; i < nums.length; i++) p[i] = p[i - 1] * nums[i];

        int product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            p[i] = (i == 0 ? 1 : p[i - 1]) * product;
            product *= nums[i];
        }

        return p;
    }
}
