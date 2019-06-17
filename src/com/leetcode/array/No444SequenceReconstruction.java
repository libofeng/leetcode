package com.leetcode.array;

import java.util.*;

public class No444SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        final Map<Integer, Integer> inDegree = new HashMap<>();
        for (List<Integer> seq : seqs) {
            Integer prev = null;
            for (int n : seq) {
                graph.putIfAbsent(n, new ArrayList<>());
                inDegree.putIfAbsent(n, 0);

                if (prev != null) {
                    graph.get(prev).add(n);
                    inDegree.put(n, inDegree.get(n) + 1);
                }
                prev = n;
            }
        }

        final int total = inDegree.size();
        if (total != org.length) return false;

        final Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> e : inDegree.entrySet()) if (e.getValue() == 0) q.offer(e.getKey());

        int index = 0;
        while (!q.isEmpty()) {
            if (q.size() > 1) return false;
            int n = q.poll();
            if (n != org[index++]) return false;

            for (int next : graph.get(n)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) q.offer(next);
            }
        }

        return index == org.length;
    }
}
