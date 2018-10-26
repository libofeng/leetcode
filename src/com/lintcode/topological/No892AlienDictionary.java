package com.lintcode.topological;

import java.util.*;

public class No892AlienDictionary {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        final Map<Character, Integer> inDegree = new HashMap<>();
        final Map<Character, Set<Character>> graph = new HashMap<>();
        final Set<Character> set = new HashSet<>();

        for (String w : words) for (char c : w.toCharArray()) set.add(c);
        for (char c : set) {
            inDegree.put(c, 0);
            graph.put(c, new HashSet<>());
        }

        for (int i = 1; i < words.length; i++) {
            char[] chars1 = words[i - 1].toCharArray(), chars2 = words[i].toCharArray();
            for (int j = 0; j < chars1.length && j < chars2.length; j++) {
                if (chars1[j] != chars2[j]) {
                    inDegree.put(chars2[j], inDegree.get(chars2[j]) + 1);
                    graph.get(chars1[j]).add(chars2[j]);
                    break;
                }
            }
        }

        final PriorityQueue<Character> q = new PriorityQueue<>();
        for (char c : set) if (inDegree.get(c) == 0) q.offer(c);

        final StringBuilder builder = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.poll();
            builder.append(c);

            for (char child : graph.get(c)) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) q.offer(child);
            }
        }

        if (builder.length() != set.size()) return "";
        return builder.toString();
    }

}
