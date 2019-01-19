package com.leetcode.math;

public class No29DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        int sign = (dividend < 0) == (divisor < 0) ? 1 : -1;

        long count = 0, ldividend = Math.abs((long) dividend), ldivisor = Math.abs((long) divisor);
        while (ldividend >= ldivisor) {
            ldividend -= ldivisor;
            count++;
        }

        if (count > Integer.MAX_VALUE) return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return (int) (sign > 0 ? count : -count);
    }
}
