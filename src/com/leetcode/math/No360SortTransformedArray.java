package com.leetcode.math;

import java.util.Arrays;

public class No360SortTransformedArray {
    /**
     * @param nums: a sorted array
     * @param a:
     * @param b:
     * @param c:
     * @return: a sorted array
     */

    // brute force solution
    // Time complexity: O(N*LogN)
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = calc(nums[i], a, b, c);
        }

        Arrays.sort(nums);
        return nums;
    }

    private int calc(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    public int[] sortTransformedArray2(int[] nums, int a, int b, int c) {
        final int n = nums.length;
        int[] result = new int[n];
        int index = a >= 0 ? (n - 1) : 0;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int left = calc(nums[lo], a, b, c), right = calc(nums[hi], a, b, c);
            if (a >= 0) {
                if (left > right) {
                    result[index--] = left;
                    lo++;
                } else {
                    result[index--] = right;
                    hi--;
                }
            } else {
                if (left < right) {
                    result[index++] = left;
                    lo++;
                } else {
                    result[index++] = right;
                    hi--;
                }
            }
        }

        return result;
    }
}
