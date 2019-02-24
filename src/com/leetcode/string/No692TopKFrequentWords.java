package com.leetcode.string;

import java.util.*;

public class No692TopKFrequentWords {
    class WordFrequent {
        String word;
        int count;

        WordFrequent(String w, int c) {
            word = w;
            count = c;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new LinkedList<>();
        final Map<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);

        final Queue<WordFrequent> pq = new PriorityQueue<>((a, b) -> b.count == a.count ? (b.word.compareTo(a.word)) : (a.count - b.count));
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (pq.size() < k) pq.offer(new WordFrequent(e.getKey(), e.getValue()));
            else {
                if (pq.peek().count <= e.getValue()) {
                    pq.offer(new WordFrequent(e.getKey(), e.getValue()));
                    pq.poll();
                }
            }
        }

        while (!pq.isEmpty()) result.add(0, pq.poll().word);
        return result;
    }
}
