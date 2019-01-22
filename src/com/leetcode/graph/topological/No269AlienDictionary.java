package com.leetcode.graph.topological;

import java.util.*;

public class No269AlienDictionary {
    public String alienOrder(String[] words) {
        final Set<Character> charSet = new HashSet<>();
        for (String w : words) for (char c : w.toCharArray()) charSet.add(c);

        final Map<Character, Integer> inDegree = new HashMap<>();
        final Map<Character, List<Character>> graph = new HashMap<>();
        for (char c : charSet) inDegree.put(c, 0);
        for (char c : charSet) graph.put(c, new ArrayList<>());

        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1], w2 = words[i];
            for (int j = 0; j < w1.length() && j < w2.length(); j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);

                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);

                    break;
                }
            }
        }

        Queue<Character> q = new PriorityQueue<>();
        for (char c : charSet) if (inDegree.get(c) == 0) q.offer(c);

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            for (char next : graph.get(c)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) q.offer(next);
            }
        }

        return sb.length() == charSet.size() ? sb.toString() : "";
    }
}
