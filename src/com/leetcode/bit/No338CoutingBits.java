package com.leetcode.bit;

public class No338CoutingBits {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        if (num == 0) return result;

        result[1] = 1;
        for (int i = 2; i <= num; i++) result[i] = result[i >> 1] + ((i & 1) == 1 ? 1 : 0);

        return result;
    }
}
