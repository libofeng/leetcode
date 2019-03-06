package com.leetcode.array;

import java.util.PriorityQueue;
import java.util.Queue;

public class No179LargestNumber {

    public String largestNumber(int[] nums) {
        final Queue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
        for (int n : nums) pq.offer(n + "");

        final StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            if (sb.length() == 0 && "0".equals(pq.peek())) pq.poll();
            else sb.append(pq.poll());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
