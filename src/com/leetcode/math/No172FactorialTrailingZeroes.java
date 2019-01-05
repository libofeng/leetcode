package com.leetcode.math;

public class No172FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
