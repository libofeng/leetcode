package com.leetcode.array;

public class No268MissingNumber {
    // XOR
    public int missingNumber(int[] nums) {
        int n = nums.length, xor = n;
        for (int i = 0; i < n; i++) xor ^= i ^ nums[i];
        return xor;
    }

    // Sum
    public int missingNumber2(int[] nums) {
        int n = nums.length, sum = n * (n + 1) / 2;
        for (int i = 0; i < n; i++) sum -= nums[i];
        return sum;
    }

    // Binary search
    public int missingNumber3(int[] nums) {
        return 0;
    }
}
