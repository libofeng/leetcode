package com.leetcode.array;

public class No370RangeAddition {
    // Time: O(KN)
    public int[] getModifiedArray(int length, int[][] updates) {
        final int[] nums = new int[length];

        for (int[] update : updates) {
            for (int i = update[0], val = update[2]; i <= update[1]; i++) nums[i] += val;
        }

        return nums;
    }

    // Time: O(K + N)
    public int[] getModifiedArray2(int length, int[][] updates) {
        final int[] nums = new int[length];

        for (int[] u : updates) {
            nums[u[0]] += u[2];
            if (u[1] + 1 < length) nums[u[1] + 1] += -u[2];
        }

        for (int i = 1; i < nums.length; i++) nums[i] += nums[i - 1];
        return nums;
    }
}
