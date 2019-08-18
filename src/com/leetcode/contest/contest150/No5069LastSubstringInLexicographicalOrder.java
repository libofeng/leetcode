package com.leetcode.contest.contest150;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class No5069LastSubstringInLexicographicalOrder {
    public String lastSubstring(String s) {
        int[] sa = doLarssonSadakane3(s.toCharArray());
        return s.substring(sa[sa.length - 1]);
    }

    public int[] doLarssonSadakane3(char[] str) {
        int n = str.length;
        final int[] rank = new int[n + 1];
        int[] b = new int[n + 1];
        long[] v = new long[n + 1];
        for (int i = 0; i < n + 1; i++) {
            rank[i] = i == n ? -1 : str[i];
            v[i] = (long) rank[i] << 32 | i;
        }
        b[0] = 0;
        b[n] = 0;
        final int m = n + 1;
        Queue<int[]> q = new ArrayDeque<int[]>();
        q.add(new int[]{0, n + 1, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int l = cur[0], r = cur[1];
            final int h = cur[2];
            if (r - l <= 1) continue;
            for (int i = l; i < r; i++) {
                int a = (int) v[i];
                v[i] = (long) (a + h < m ? rank[a + h] : 99999999) << 32 | a;
            }
            Arrays.sort(v, l, r);
            for (int i = l; i < r - 1; i++) {
                if (v[i] >>> 32 == v[i + 1] >>> 32) {
                    b[i + 1] = b[i];
                } else {
                    b[i + 1] = i + 1;
                }
            }
            for (int i = l; i < r; i++) rank[(int) v[i]] = b[i];
            int prev = l;
            for (int i = l; i < r; i++) {
                if (i + 1 == r || b[i + 1] > b[i]) {
                    if (i + 1 - prev > 1) {
                        q.add(new int[]{prev, i + 1, h == 0 ? 1 : h * 2});
                    }
                    prev = i + 1;
                }
            }
        }
        int[] w = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            w[i] = (int) v[i];
        }
        return w;
    }
}
