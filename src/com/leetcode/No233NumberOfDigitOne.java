package com.leetcode;

public class No233NumberOfDigitOne {

    public int countDigitOne(int n) {
        int res = 0, a = 1, b = 1;
        while (n > 0) {
            res += (n + 8) / 10 * a + ((n % 10 == 1) ? 1 : 0) * b;
            b += n % 10 * a;
            a *= 10;
            n /= 10;
        }
        return res;
    }
}
