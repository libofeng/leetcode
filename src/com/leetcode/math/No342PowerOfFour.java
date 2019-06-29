package com.leetcode.math;

public class No342PowerOfFour {
    public boolean isPowerOfFour(int num) {
        while (num > 1 && (num & 3) == 0) num >>= 2;
        return num == 1;
    }

    public boolean isPowerOfFour2(int num) {
        while (num > 1 && num % 4 == 0) num >>= 2;
        return num == 1;
    }
}
