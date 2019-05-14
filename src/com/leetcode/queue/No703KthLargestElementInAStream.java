package com.leetcode.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class No703KthLargestElementInAStream {
    private Queue<Integer> pq = new PriorityQueue<>();
    private int k;

    public No703KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
}
