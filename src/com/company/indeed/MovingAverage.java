package com.company.indeed;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private static final long EXPIRED_TIME = 300 * 1000;

    class Node {
        int val;
        long createTime;

        public Node(int val, long createTime) {
            this.val = val;
            this.createTime = createTime;
        }
    }

    private Queue<Node> q = new LinkedList<>();
    private long sum = 0;

    private boolean isExpired(long now, long createTime) {
        return now - createTime >= EXPIRED_TIME;
    }

    private long getNow() {
        return System.currentTimeMillis();
    }

    private void removeExpired() {
        while (!q.isEmpty() && isExpired(getNow(), q.peek().createTime)) sum -= q.poll().val;
    }

    public void record(int x) {
        q.offer(new Node(x, getNow()));
        sum += x;
    }

    private double getAverage() {
        removeExpired();

        if (q.isEmpty()) return 0;
        return sum * 1.0D / q.size();
    }
}
