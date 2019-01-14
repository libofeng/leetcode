package com.leetcode.array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class No975OddEvenJump {
    public int oddEvenJumps(int[] A) {
        final boolean[][] dp = new boolean[A.length][2];

        Arrays.fill(dp[A.length - 1], true);
        int total = 1;

        for (int i = A.length - 2; i >= 0; i--) {
            int minIndex = i, min = Integer.MAX_VALUE, maxIndex = i, max = Integer.MIN_VALUE;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] >= A[i] && A[j] < min) {
                    min = A[j];
                    minIndex = j;
                }

                if (A[j] <= A[i] && A[j] > max) {
                    max = A[j];
                    maxIndex = j;
                }
            }

            if (maxIndex > i && dp[maxIndex][1]) dp[i][0] = true;
            if (minIndex > i && dp[minIndex][0]) dp[i][1] = true;
            if (dp[i][1]) total++;
        }

        return total;
    }

    public int oddEvenJumps2(int[] A) {
        final int n = A.length;
        final boolean[][] dp = new boolean[n][2];
        final TreeMap<Integer, Integer> treemap = new TreeMap<>();

        Arrays.fill(dp[n - 1], true);
        treemap.put(A[n - 1], n - 1);

        int total = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> ceiling = treemap.ceilingEntry(A[i]);
            if (ceiling != null && dp[ceiling.getValue()][0]) dp[i][1] = true;
            if (dp[i][1]) total++;

            Map.Entry<Integer, Integer> floor = treemap.floorEntry(A[i]);
            if (floor != null && dp[floor.getValue()][1]) dp[i][0] = true;

            treemap.put(A[i], i);
        }

        return total;
    }
}
