package com.leetcode.bit;

public class No476NumberComplement {
    public int findComplement(int num) {
        long n = 1;
        while (n <= num) n <<= 1;

        return (int) (num ^ --n);
    }
}
