package com.leetcode.unionfind;

public class No765CouplesHoldingHands {

    // https://leetcode.com/problems/couples-holding-hands/discuss/160104/Union-find-understand-in-60-seconds-beats-99.6
    public int minSwapsCouples(int[] row) {
        final int[] groups = new int[row.length];

        final int n = row.length / 2;
        int swap = 0;

        for (int i = 0; i < n; i++) {
            groups[2 * i] = i;
            groups[2 * i + 1] = i;
        }

        for (int i = 0; i < n; i++) {
            int people1 = row[2 * i], people2 = row[2 * i + 1];

            int couple1 = people1 / 2, couple2 = people2 / 2;
            if (couple1 != couple2) {
                int p = groups[people1], q = groups[people2];
                if (p != q) {
                    swap++;

                    for (int j = 0; j < row.length; j++) {
                        if (groups[j] == p) groups[j] = q;
                    }
                }
            }
        }

        return swap;
    }
}
