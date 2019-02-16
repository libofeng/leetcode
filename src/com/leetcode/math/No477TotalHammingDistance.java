package com.leetcode.math;

public class No477TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int ones = 0;
            for (int n : nums) if (((n >> i) & 1) == 1) ones++;
            total += (nums.length - ones) * ones;
        }

        return total;
    }
}
