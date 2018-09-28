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
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int nA : A) {
            for (int nB : B) {
                int sum = nA + nB;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int nC : C) {
            for (int nD : D) {
                count += map.getOrDefault(-nC - nD, 0);
            }
        }

        return count;
    }
}
