package com.leetcode.math;

public class No326PowerOfThree {
    // https://leetcode.com/problems/power-of-three/discuss/77876/**-A-summary-of-all-solutions-(new-method-included-at-15%3A30pm-Jan-8th)
    public boolean isPowerOfThree(int n) {
        return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree(n / 3)));
    }


    public boolean isPowerOfThree2(int n) {
        while (n > 1 && n % 3 == 0) n /= 3;
        return n == 1;
    }
}
