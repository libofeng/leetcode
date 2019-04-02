package com.leetcode.string;

import java.util.*;

public class No767ReorganizeString {
    // https://leetcode.com/problems/reorganize-string/discuss/128907/Java-solution-99-similar-to-358
    public String reorganizeString(String S) {
        if (S == null || S.length() <= 2) return S;

        final Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        final Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        final Queue<Map.Entry<Character, Integer>> q = new LinkedList<>();
        pq.addAll(counter.entrySet());

        final StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            sb.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);
            q.offer(entry);

            while (q.size() > 1) { // this is the key to separate the characters
                Map.Entry<Character, Integer> e = q.poll();
                if (e.getValue() > 0) pq.offer(e);
            }
        }

        return sb.length() == S.length() ? sb.toString() : "";
    }
}
