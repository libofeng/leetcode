package com.leetcode.math;

public class No231PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;

        while (n > 1) {
            if ((n & 1) == 1) return false;
            n >>= 1;
        }
        return true;
    }
}
