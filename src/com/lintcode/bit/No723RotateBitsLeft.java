package com.lintcode.bit;

public class No723RotateBitsLeft {
    /**
     * @param n: a number
     * @param d: digit needed to be rorated
     * @return: a number
     */
    public int leftRotate(int n, int d) {
        d = d % 32;
        return (n << d) | (n >>> (32 - d));
    }
}
