package com.leetcode.math;

public class No633SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        long lo = 0, hi = (long) Math.sqrt(c);
        while (lo <= hi) {
            long n = lo * lo + hi * hi;
            if (c == n) return true;
            if (n > c) hi--;
            else lo++;
        }
        return false;
    }
}
