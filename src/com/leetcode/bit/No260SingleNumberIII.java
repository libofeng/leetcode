package com.leetcode.bit;

public class No260SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int n : nums) diff ^= n;

        diff &= -diff;

        int n1 = 0, n2 = 0;
        for (int n : nums) {
            if ((n & diff) > 0) n1 ^= n;
            else n2 ^= n;
        }

        return new int[]{n1, n2};
    }
}
