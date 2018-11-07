package com.lintcode.bit;

public class No721NextSparseNumber {
    /**
     * @param x: a number
     * @return: return the next sparse number behind x
     */
    public int nextSparseNum(int x) {
        for (int i = 31; i >= 0; i--) {
            if (((x >> i) & 1) == 1 && ((x >> (i - 1)) & 1) == 1) {
                int idx = i + 1;
                while (idx <= 31 && ((x >> (idx + 1)) & 1) == 1) idx += 2;
                return ((x >> idx) << idx) | (1 << idx);
            }
        }
        return x;
    }
}
