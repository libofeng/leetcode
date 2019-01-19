package com.leetcode.math;

public class No50PowXN {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        if (n < 0) return 1 / x * myPow(1 / x, -(n + 1));

        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x, n - 1);
    }

    public double myPow2(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;

        double result = 1;
        if (n < 0) {
            x = 1 / x;
            result *= x;

            n = -(n + 1);
        }

        while (n > 0) {
            if (n % 2 == 0) {
                x = x * x;
                n /= 2;
            } else {
                result *= x;
                n--;
            }
        }

        return result;
    }

}
