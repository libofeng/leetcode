package com.leetcode.array;

import java.util.Arrays;

public class No137SingleNumberII {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i += 3) if (nums[i] != nums[i + 1]) return nums[i];
        return nums[nums.length - 1];
    }

    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for (int n : nums) twos = (twos ^ n) & ~(ones = (ones ^ n) & ~twos);
        return ones;
    }

    public int singleNumber3(int[] nums) {
        final int times = 3;

        int num = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int n : nums) if (((n >>> i) & 1) == 1) total = (total + 1) % times;

            if (total > 0) num |= (1 << i);
        }

        return num;
    }
}
