package com.leetcode.graph;

import java.util.*;

public class No815BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        final Map<Integer, List<Integer>> stopBusMap = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopBusMap.putIfAbsent(stop, new ArrayList<>());
                stopBusMap.get(stop).add(i);
            }
        }

        if (!stopBusMap.containsKey(S) || !stopBusMap.containsKey(T)) return -1;

        boolean[] visited = new boolean[routes.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);

        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int stop = q.poll();
                for (int bus : stopBusMap.get(stop)) {
                    if (visited[bus]) continue;
                    visited[bus] = true;

                    for (int s : routes[bus]) {
                        if (s == T) return level;
                        q.offer(s);
                    }
                }
            }
            level++;
        }

        return -1;
    }
}
