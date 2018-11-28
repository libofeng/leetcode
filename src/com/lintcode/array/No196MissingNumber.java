package com.lintcode.array;

import java.util.Arrays;
import java.util.BitSet;

public class No196MissingNumber {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    public int findMissing(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) if (nums[i] != i) return i;
        return nums.length;
    }

    public int findMissing2(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;

        return nums.length * (nums.length + 1) / 2 - sum;
    }

    public int findMissing3(int[] nums) {
        BitSet bitSet = new BitSet(nums.length + 1);
        for (int n : nums) bitSet.set(n);
        for (int i = 0; i <= nums.length; i++) if (!bitSet.get(i)) return i;
        return 0;
    }
}
