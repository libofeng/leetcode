package com.leetcode.array;

import java.util.Arrays;

public class No238ProductOfArrayExceptSelf {
    // two extra arrays
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        final int[] left = new int[nums.length], right = new int[nums.length], product = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < n; i++) left[i] = left[i - 1] * nums[i - 1];

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) right[i] = right[i + 1] * nums[i + 1];

        for (int i = 0; i < n; i++) product[i] = left[i] * right[i];
        return product;
    }

    // use only one result array
    public int[] productExceptSelf2(int[] nums) {
        final int n = nums.length;
        final int[] left = new int[nums.length], product = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < n; i++) left[i] = left[i - 1] * nums[i - 1];

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            product[i] = left[i] * right;
            right *= nums[i];
        }
        return product;
    }

    // reuse the result array
    public int[] productExceptSelf3(int[] nums) {
        final int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        for (int i = 1; i < nums.length; i++) result[i] = result[i - 1] * nums[i - 1];

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }
}
