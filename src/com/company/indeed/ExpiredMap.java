package com.company.indeed;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ExpiredMap {
    class Node implements Comparable<Node> {
        String key;
        int val;
        long expiredTime;

        public Node(String key, int val, long expiredTime) {
            this.key = key;
            this.val = val;
            this.expiredTime = expiredTime;
        }

        @Override
        public int compareTo(Node that) {
            if (this.expiredTime == that.expiredTime) return 0;
            return this.expiredTime < that.expiredTime ? -1 : 1;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() > expiredTime;
        }
    }

    private static final Map<String, Node> map = new HashMap<>();
    private static final Queue<Node> pq = new PriorityQueue<>();

    int get(String key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        if (node.isExpired()) {
            map.remove(key);
            return -1;
        }

        return node.val;
    }

    void put(String key, int value, int duration) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value, duration + System.currentTimeMillis());
            map.put(key, node);
        } else {
            node.val = value;
            node.expiredTime = duration + System.currentTimeMillis();
            pq.remove(node);
        }
        pq.offer(node);
    }

    void removeExpired() {
        long now = System.currentTimeMillis();
        while (pq.peek().expiredTime < now) pq.poll();
    }
}
