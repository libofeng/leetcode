package com.leetcode.string;

import java.util.*;

public class No358RearrangeStringKDistanceApart {
    public static void main(String[] args) {
        No358RearrangeStringKDistanceApart solution = new No358RearrangeStringKDistanceApart();
        String result = solution.rearrangeString("aabbccddee", 3);
        System.out.println("result = " + result);
    }

    public String rearrangeString(String s, int k) {
        final Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        final Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> e : map.entrySet()) pq.offer(e);

        final StringBuilder sb = new StringBuilder();
        final Queue<Map.Entry<Character, Integer>> waitingQ = new LinkedList<>();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> e = pq.poll();

            e.setValue(e.getValue() - 1);
            waitingQ.offer(e);
            sb.append(e.getKey());

            if (waitingQ.size() < k) continue;

            e = waitingQ.poll();
            if (e.getValue() > 0) pq.offer(e);
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }
}
