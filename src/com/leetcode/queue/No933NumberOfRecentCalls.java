package com.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class No933NumberOfRecentCalls {

    private final Queue<Integer> q = new LinkedList<>();
    private final int k = 3000;

    public No933NumberOfRecentCalls() {

    }

    public int ping(int t) {
        int min = t - k;
        while (!q.isEmpty() && q.peek() < min) q.poll();
        q.offer(t);

        return q.size();
    }
}
