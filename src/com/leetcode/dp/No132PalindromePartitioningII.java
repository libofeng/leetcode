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

    // refer to this very good article:
    // https://blog.csdn.net/yutianzuijin/article/details/16850031
    public int minCut2(String s) {
        final int n = s.length();
        final char[] c = s.toCharArray();

        final boolean[][] p = new boolean[n][n];
        final int[] cuts = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++)
                if (c[i] == c[j] && (j - i <= 1 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                }
        }


        for (int i = n - 1; i >= 0; i--) {
            cuts[i] = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) if (p[i][j]) cuts[i] = Math.min(cuts[j + 1] + 1, cuts[i]);
        }

        return cuts[0] - 1;
    }

    // simplify minCut2 to have this minCut3 solution
    public int minCut3(String s) {
        final int n = s.length();
        final char[] c = s.toCharArray();

        final boolean[][] p = new boolean[n][n];
        final int[] cuts = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            cuts[i] = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (c[i] == c[j] && (j - i <= 1 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    cuts[i] = Math.min(cuts[j + 1] + 1, cuts[i]);
                }
            }
        }

        return cuts[0] - 1;
    }
}
