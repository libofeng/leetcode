package com.leetcode.bit;

public class No461HammingDistance {
    public int hammingDistance(int x, int y) {
        if ((x ^ y) == 0) return 0;
        int count = (x & 1) == (y & 1) ? 0 : 1;
        return count + hammingDistance(x >> 1, y >> 1);
    }


    public int hammingDistance2(int x, int y) {
        return (x ^ y) == 0 ? 0 : (((x & 1) ^ (y & 1)) + hammingDistance(x >> 1, y >> 1));
    }


    public int hammingDistance3(int x, int y) {
        int n = x ^ y, distance = 0;
        for (int i = 0; i < 32; i++) distance += ((n >> i) & 1);
        return distance;
    }

    public int hammingDistance4(int x, int y) {
        int d = 0;
        for(int i = 0;i<32;i++) d += ((x>>i) & 1) ^ ((y>>i) & 1);
        return d;
    }
}
