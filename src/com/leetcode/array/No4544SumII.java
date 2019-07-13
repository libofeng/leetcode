package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class No4544SumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        for (int nA : A) {
            for (int nB : B) {
                for (int nC : C) {
                    for (int nD : D) {
                        if (nA + nB + nC + nD == 0) count++;
                    }
                }
            }
        }

        return count;
    }

    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) for (int b : B) map.put((a + b), map.getOrDefault((a + b), 0) + 1);

        int count = 0;
        for (int c : C) for (int d : D) count += map.getOrDefault(-c - d, 0);
        return count;
    }
}
