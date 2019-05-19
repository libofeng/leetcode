package com.leetcode.contest.contest137;

import java.util.PriorityQueue;
import java.util.Queue;

public class No1046LastStoneWeightUser {
    public int lastStoneWeight(int[] stones) {
        final Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int n : stones) pq.offer(n);

        while (pq.size() > 1) pq.offer(pq.poll() - pq.poll());
        return pq.poll();
    }
}
