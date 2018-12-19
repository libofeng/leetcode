package com.lintcode.math;

public class No428PowXN {
    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) return (1 / x) * myPow(1 / x, -(n + 1));

        return (n & 1) == 0 ? myPow(x * x, n / 2) : x * myPow(x, n - 1);
    }


    public double myPow2(double x, int n) {
        double result = 1;
        if (n < 0) {
            result = 1 / x;
            n = -(n + 1);
            x = 1 / x;
        }
        if (n == 0) return result;

        while (n > 1) {
            if ((n & 1) == 1) {
                result *= x;
                n -= 1;
            } else {
                x *= x;
                n /= 2;
            }
        }

        return result * x;
    }
}
