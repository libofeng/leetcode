package com.lintcode.bit;

public class No835HammingDistance {
    /**
     * @param x: an integer
     * @param y: an integer
     * @return: return an integer, denote the Hamming Distance between two integers
     */
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) if (((x >> i) & 1) != ((y >> i) & 1)) count++;
        return count;
    }
}
