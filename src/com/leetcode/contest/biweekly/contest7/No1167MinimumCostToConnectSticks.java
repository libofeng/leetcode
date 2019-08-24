package com.leetcode.contest.biweekly.contest7;

import java.util.PriorityQueue;
import java.util.Queue;

public class No1167MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        final Queue<Integer> pq = new PriorityQueue<>();
        for (int n : sticks) pq.offer(n);

        int cost = 0;
        while (pq.size() > 1) {
            int a = pq.poll(), b = pq.poll(), n = a + b;
            cost += n;
            pq.offer(n);
        }

        return cost;
    }
}
