package com.leetcode.math;

public class No372SuperPow {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        if (b.length == 1) return pow(a, b[0]);
        return powArray(a, b, b.length - 1);
    }

    private int powArray(int a, int[] b, int end) {
        if (end < 0) return 1;
        return (pow(powArray(a, b, end - 1), 10) * pow(a, b[end])) % MOD;
    }

    private int pow(int a, int k) {
        int pow = 1, p = a % MOD;
        for (int i = 0; i < k; i++) pow = (pow * p) % MOD;
        return pow;
    }
}
