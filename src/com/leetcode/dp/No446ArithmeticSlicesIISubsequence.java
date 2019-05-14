package com.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class No446ArithmeticSlicesIISubsequence {
    public int numberOfArithmeticSlices(int[] A) {
        final int n = A.length;
        Map<Integer, Integer>[] maps = new Map[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;

                int d = (int) diff;
                int c1 = maps[i].getOrDefault(d, 0), c2 = maps[j].getOrDefault(d, 0);
                count += c2;
                maps[i].put(d, c1 + c2 + 1);
            }
        }

        return count;
    }
}
