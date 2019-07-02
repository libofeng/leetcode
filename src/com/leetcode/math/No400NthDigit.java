package com.leetcode.math;

public class No400NthDigit {
    public int findNthDigit(int n) {
        int start = 1, len = 1;
        long count = 9;
        while (n > len * count) {
            n -= len * count;

            len++;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        int k = (n - 1) % len;
        return ("" + start).charAt(k) - '0';
    }

    public int findNthDigit2(int n) {
        int start = 1, len = 1;
        while (n > count(len)) {
            n -= count(len);

            len++;
            start *= 10;
        }

        start += (n - 1) / len;
        int k = (n - 1) % len;
        return ("" + start).charAt(k) - '0';
    }

    private long count(int len) {
        return len * 9 * (long) Math.pow(10, (len - 1));
    }
}
