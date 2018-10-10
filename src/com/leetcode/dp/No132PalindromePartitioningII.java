package com.leetcode.dp;

public class No132PalindromePartitioningII {
    public int minCut(String s) {
        final char[] c = s.toCharArray();
        final int len = c.length;
        final int[] cuts = new int[len];
        final boolean[][] p = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (c[i] == c[j] && (i - j <= 1 || p[j + 1][i - 1])) {
                    p[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cuts[j - 1] + 1);
                }
            }
            cuts[i] = min;
        }

        return cuts[len - 1];
    }
}
