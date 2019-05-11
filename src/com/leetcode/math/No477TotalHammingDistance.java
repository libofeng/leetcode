package com.leetcode.math;

public class No477TotalHammingDistance {
    // Time: O(N), Space: O(1)
    // distance of a bit: ones * not-ones
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int ones = 0;
            for (int n : nums) if (((n >> i) & 1) == 1) ones++;
            total += (nums.length - ones) * ones;
        }

        return total;
    }

    // Brute force, TLE
    // Time: O(N^2), Space: O(1)
    public int totalHammingDistance2(int[] nums) {
        int d = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                d += distance(nums[i], nums[j]);
            }
        }
        return d;
    }

    private int distance(int a, int b) {
        int n = a ^ b, d = 0;
        for (int i = 0; i < 32; i++) if (((n >> i) & 1) == 1) d++;
        return d;
    }
}
