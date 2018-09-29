package com.leetcode.array;

public class No238ProductOfArrayExceptSelf {
    // two extra arrays
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length], right = new int[nums.length], R = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) left[i] = 1;
            else left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) right[i] = 1;
            else right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            R[i] = left[i] * right[i];
        }

        return R;
    }

    // use only one result array
    public int[] productExceptSelf2(int[] nums) {
        int[] R = new int[nums.length];

        R[0] = 1;
        for (int i = 1; i < nums.length; i++) R[i] = R[i - 1] * nums[i - 1];

        int productR = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            R[i] = productR * R[i];
            productR *= nums[i];
        }

        return R;
    }
}
