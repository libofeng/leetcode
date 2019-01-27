package com.leetcode.math;

public class No982TriplesWithBitwiseANDEqualToZero {
    public int countTriplets(int[] A) {
        int[] f = new int[1 << 16];
        for (int v : A) f[v]++;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 1 << 16; j++) {
                if (j << ~i >= 0) {
                    f[j] += f[j | 1 << i];
                }
            }
        }
        for (int i = 0; i < 1 << 16; i++) {
            f[i] = f[i] * f[i] * f[i];
        }
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 1 << 16; j++) {
                if (j << ~i >= 0) {
                    f[j] -= f[j | 1 << i];
                }
            }
        }
        return f[0];
    }
}
