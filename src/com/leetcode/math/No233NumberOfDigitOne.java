package com.leetcode.math;

public class No233NumberOfDigitOne {
    // https://leetcode.com/problems/number-of-digit-one/discuss/64381/4%2B-lines-O(log-n)-C%2B%2BJavaPython
    // Haven't understood how this solution work
    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
        return ones;
    }
}
