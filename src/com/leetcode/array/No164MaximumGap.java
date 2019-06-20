package com.leetcode.array;

import java.util.Arrays;

public class No164MaximumGap {
    public int maximumGap(int[] nums) {
        final int n = nums.length;
        if (n < 2) return 0;

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int size = (int) Math.ceil((double) (max - min) / (n - 1));
        final int[] maxBucket = new int[n - 1], minBucket = new int[n - 1];
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        Arrays.fill(minBucket, Integer.MAX_VALUE);

        for (int num : nums) {
            if (num == min || num == max) continue;
            int idx = (num - min) / size;
            maxBucket[idx] = Math.max(maxBucket[idx], num);
            minBucket[idx] = Math.min(minBucket[idx], num);
        }

        int prev = min, maxGap = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxBucket[i] == Integer.MIN_VALUE || minBucket[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, minBucket[i] - prev);
            prev = maxBucket[i];
        }
        maxGap = Math.max(maxGap, max - prev);

        return maxGap;
    }
}
