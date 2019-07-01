package com.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class No362DesignHitCounter {

    /**
     * Initialize your data structure here.
     */
    private Queue<Integer> q = new LinkedList<>();

    public No362DesignHitCounter() {

    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        q.offer(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int start = timestamp - 5 * 60;
        while (!q.isEmpty() && q.peek() <= start) q.poll();

        return q.size();
    }
}
