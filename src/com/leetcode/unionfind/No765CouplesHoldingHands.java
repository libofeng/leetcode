package com.leetcode.unionfind;

public class No765CouplesHoldingHands {

    // https://leetcode.com/problems/couples-holding-hands/discuss/160104/Union-find-understand-in-60-seconds-beats-99.6
    public int minSwapsCouples(int[] row) {
        final int n = row.length / 2;
        final int[] groups = new int[row.length];
        for (int i = 0; i < n; i++) {
            groups[i * 2] = i;
            groups[i * 2 + 1] = i;
        }

        int swap = 0;
        for (int i = 0; i < n; i++) {
            int people1 = row[i * 2], people2 = row[i * 2 + 1]; // find every pair peoples in the row
            int couple1 = people1 / 2, couple2 = people2 / 2;

            if (couple1 == couple2) continue; // if the pair people are couple, skip
            int p = groups[people1], q = groups[people2];
            if (p == q) continue; // if the couple has been swapped

            swap++;
            union(groups, p, q);
        }

        return swap;
    }

    private void union(int[] groups, int p, int q) {
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] == p) groups[i] = q;
        }
    }
}
