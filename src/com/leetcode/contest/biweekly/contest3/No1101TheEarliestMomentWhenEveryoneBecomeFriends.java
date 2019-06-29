package com.leetcode.contest.biweekly.contest3;

import java.util.Arrays;

public class No1101TheEarliestMomentWhenEveryoneBecomeFriends {
    public int earliestAcq(int[][] logs, int N) {
        final int[] root = new int[N];
        for (int i = 0; i < N; i++) root[i] = i;
        int total = N;

        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        for (int[] log : logs) {
            int date = log[0], a = log[1], b = log[2];

            int p = find(root, a), q = find(root, b);
            if (p != q) {
                root[p] = q;
                if (--total == 1) return date;
            }
        }

        return -1;
    }

    private int find(int[] root, int i) {
        while (i != root[i]) {
            root[i] = root[root[i]];
            i = root[i];
        }

        return i;
    }
}
