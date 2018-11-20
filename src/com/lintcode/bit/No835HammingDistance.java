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

    public int hammingDistance2(int x, int y) {
        int count = 0, xor = x ^ y;
        for (int i = 0; i < 32; i++) count += (xor >> i) & 1;
        return count;
    }

    public int hammingDistance3(int x, int y) {
        int count = 0, xor = x ^ y;
        while (xor > 0 && ++count > 0) xor &= xor - 1;
        return count;
    }

    public int hammingDistance4(int x, int y) {
        if ((x ^ y) == 0) return 0;
        return ((x ^ y) & 1) + hammingDistance4(x >> 1, y >> 1);
    }

    public int hammingDistance5(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
