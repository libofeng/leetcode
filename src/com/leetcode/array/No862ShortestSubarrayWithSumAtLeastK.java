package com.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

public class No862ShortestSubarrayWithSumAtLeastK {
    // TLE
    // Time: O(N^2), Space: O(N)
    public int shortestSubarray(int[] A, int K) {
        final int n = A.length;
        final int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + A[i - 1];

        int minLen = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (sums[i] - sums[j] >= K) minLen = Math.min(minLen, i - j);
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    // https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/143726/C%2B%2BJavaPython-O(N)-Using-Deque
    public int shortestSubarray2(int[] A, int K) {
        final int n = A.length;
        final int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + A[i - 1];

        int minLen = Integer.MAX_VALUE;
        final Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            int sum = sums[i];
            while (!dq.isEmpty() && sum - sums[dq.peek()] >= K) minLen = Math.min(minLen, i - dq.poll());
            while (!dq.isEmpty() && sums[dq.peek()] >= sum) dq.poll();
            dq.offer(i);
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
