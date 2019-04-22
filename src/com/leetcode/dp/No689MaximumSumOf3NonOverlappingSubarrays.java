package com.leetcode.dp;

import java.util.Arrays;

public class No689MaximumSumOf3NonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        final int n = nums.length;
        final int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + nums[i - 1];

        final int[] left = new int[n], right = new int[n];
        int leftMax = 0, rightMax = 0;

        for (int i = k; i < n; i++) {
            int sum = sums[i] - sums[i - k];
            if (sum > leftMax) {
                left[i] = i - k;
                leftMax = sum;
            } else left[i] = left[i - 1];
        }

        for (int i = n - k; i >= 0; i--) {
            int sum = sums[i + k] - sums[i];
            if (sum > rightMax) {
                right[i] = i;
                rightMax = sum;
            } else right[i] = right[i + 1];
        }

        int max = 0, a = 0, b = 0, c = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int sum = sums[i + k] - sums[i];
            sum += sums[left[i] + k] - sums[left[i]];
            sum += sums[right[i + k] + k] - sums[right[i + k]];

            if (sum > max) {
                a = left[i];
                b = i;
                c = right[i + k];
                max = sum;
            }
        }

        return new int[]{a, b, c};
    }

    public static void main(String[] args) {
        No689MaximumSumOf3NonOverlappingSubarrays solution = new No689MaximumSumOf3NonOverlappingSubarrays();
        int[] result = solution.maxSumOfThreeSubarrays(new int[]{7, 13, 20, 19, 19, 2, 10, 1, 1, 19}, 3);
        System.out.println("result = " + Arrays.toString(result));
    }
}
