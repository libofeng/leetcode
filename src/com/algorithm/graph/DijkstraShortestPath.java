package com.algorithm.graph;

import java.util.*;

public class DijkstraShortestPath {
    /**
     * Given a list of (source, target, weight) edge pairs, return the shortest distance from s to any
     * other nodes in the graph. Any unreachable node has a distance of Integer.MAX_VALUE.
     *
     * @param edges List of tuple representation of edges containing [source, target weight].
     * @param N     The graph contains nodes from 1 to N.
     * @param s     Start node of the shortest path tree
     * @return Shortest path from s to other nodes in the graph.
     */
    public Map<Integer, Integer> dijkstraShortestPath(int[][] edges, int N, int s) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        Map<Integer, Integer> dist = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(edge1 -> edge1[1]));
        minHeap.offer(new int[]{s, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            if (dist.containsKey(curr[0])) continue;
            dist.put(curr[0], curr[1]);
            if (adjList.containsKey(curr[0])) {
                for (int[] edge : adjList.get(curr[0])) {
                    minHeap.offer(new int[]{edge[0], edge[1] + curr[1]});
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!dist.containsKey(i)) dist.put(i, Integer.MAX_VALUE);
        }

        return dist;
    }
}
