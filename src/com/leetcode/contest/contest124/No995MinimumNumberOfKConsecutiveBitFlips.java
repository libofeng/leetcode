package com.leetcode.contest.contest124;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class No995MinimumNumberOfKConsecutiveBitFlips {
    // TLE
    public int minKBitFlips(int[] A, int K) {
        final int n = A.length;
        final Set<String> visited = new HashSet<>();
        String start = toString(A), end = getFinalString(A);
        if (start.equals(end)) return 0;

        final Queue<String> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            steps++;

            while (size-- > 0) {
                String state = q.poll();
                for (int i = 0; i <= n - K; i++) {
                    char[] chars = state.toCharArray();
                    for (int j = 0; j < K; j++) chars[i + j] = flip(chars[i + j]);

                    String next = new String(chars);
                    if (visited.contains(next)) continue;
                    if (end.equals(next)) return steps;

                    visited.add(next);
                    q.offer(next);
                }
            }
        }

        return -1;
    }

    private char flip(char c) {
        return c == '0' ? '1' : '0';
    }

    private String toString(int[] A) {
        final StringBuilder sb = new StringBuilder();
        for (int n : A) sb.append(n);
        return sb.toString();
    }

    private String getFinalString(int[] A) {
        final StringBuilder sb = new StringBuilder();
        for (int n : A) sb.append(1);
        return sb.toString();
    }
}
