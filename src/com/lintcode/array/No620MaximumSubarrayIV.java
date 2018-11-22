package com.lintcode.array;

public class No620MaximumSubarrayIV {
    /**
     * @param nums: an array of integer
     * @param k:    an integer
     * @return: the largest sum
     */
    public int maxSubarray4(int[] nums, int k) {
        final int n = nums.length;
        if (k > n) return 0;

        int[] minSums = new int[n + 1], sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
            minSums[i] = Math.min(minSums[i - 1], sums[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            max = Math.max(max, sums[i] - minSums[i - k]);
        }

        return max;
    }
}
