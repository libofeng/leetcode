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

    // https://www.youtube.com/watch?v=htX69j1jf5U
    // https://github.com/Nideesh1/Algo/blob/master/leetcode/L_29.java
    public int divide2(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int sign = (dividend < 0) == (divisor < 0) ? 1 : -1;

        int count = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (dividend - divisor >= 0) {
            int move = 0;
            while (dividend - (divisor << 1 << move) >= 0) move++;

            count += 1 << move;
            dividend -= divisor << move;
        }
        return sign > 0 ? count : -count;
    }
}
