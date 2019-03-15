package com.company.indeed;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageTooMuchData {
    private static final int EXPIRED_TIME = 300;

    class Node {
        int val, num;
        long createTime;

        public Node(int val, long createTime) {
            this.val = val;
            this.createTime = createTime;
            num = 1;
        }
    }

    private Deque<Node> q = new LinkedList<>();
    private long sum = 0, count = 0;

    private boolean isExpired(long now, long createTime) {
        return now - createTime >= EXPIRED_TIME;
    }

    private long getNow() {
        return System.currentTimeMillis() / 1000;
    }

    private void removeExpired() {
        while (!q.isEmpty() && isExpired(getNow(), q.peek().createTime)) {
            Node node = q.poll();
            sum -= node.val;
            count -= node.num;
        }
    }

    public void record(int x) {
        long time = getNow();
        if (time == q.peekLast().createTime) {
            Node node = q.peekLast();
            node.num++;
            node.val += x;
        } else q.offer(new Node(x, time));

        sum += x;
        count++;
        removeExpired();
    }

    private double getAverage() {
        removeExpired();

        if (count == 0) return 0;
        return sum * 1.0D / count;
    }
}
