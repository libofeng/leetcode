package com.leetcode.graph;

import java.util.*;

public class No332ReconstructItinerary {
    // https://leetcode.com/problems/reconstruct-itinerary/discuss/78768/Short-Ruby-Python-Java-C%2B%2B
    public List<String> findItinerary(String[][] tickets) {
        final Map<String, Queue<String>> graph = new HashMap<>();
        for (String[] t : tickets) graph.computeIfAbsent(t[0], k -> new PriorityQueue<>()).add(t[1]);

        final LinkedList<String> result = new LinkedList<>();
        dfs(graph, result, "JFK");

        return result;
    }

    private void dfs(Map<String, Queue<String>> graph, LinkedList<String> result, String airport) {
        Queue<String> q = graph.get(airport);
        while (q != null && !q.isEmpty()) dfs(graph, result, q.poll());

        result.addFirst(airport);
    }

    // this solution doesn't work, since there will cycle in the graph
    // example test-case: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    public List<String> findItinerary2(String[][] tickets) {
        final Map<String, List<String>> graph = new HashMap<>();
        final Map<String, Integer> inDegree = new HashMap<>();
        for (String[] t : tickets) {
            graph.computeIfAbsent(t[0], k -> new ArrayList<>()).add(t[1]);
            graph.putIfAbsent(t[1], new ArrayList<>());

            inDegree.putIfAbsent(t[0], 0);
            inDegree.put(t[1], inDegree.getOrDefault(t[1], 0) + 1);
        }

        final LinkedList<String> result = new LinkedList<>();
        final Queue<String> pq = new PriorityQueue<>();
        for (Map.Entry<String, Integer> e : inDegree.entrySet()) if (e.getValue() == 0) pq.offer(e.getKey());

        while (!pq.isEmpty()) {
            String airport = pq.poll();
            result.add(airport);

            for (String next : graph.get(airport)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) pq.offer(next);
            }
        }

        return result;
    }
}
