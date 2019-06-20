package com.leetcode.bit;

public class No201BitwiseANDOfNumbersRange {
    // https://leetcode.com/problems/bitwise-and-of-numbers-range/discuss/56729/Bit-operation-solution(JAVA)
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0; // i means we have how many bits are 0 on the right
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m << i;
    }
}
