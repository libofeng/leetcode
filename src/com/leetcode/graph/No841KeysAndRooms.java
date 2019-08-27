package com.leetcode.graph;

import java.util.*;

public class No841KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        final Set<Integer> visited = new HashSet<>();
        dfs(rooms, 0, visited);

        return visited.size() == rooms.size();
    }

    private void bfs(List<List<Integer>> rooms, int start, Set<Integer> visited) {
        final Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int n = q.poll();
            if (!visited.add(n)) continue;

            for (int next : rooms.get(n)) q.offer(next);
        }
    }

    private void dfs(List<List<Integer>> rooms, int n, Set<Integer> visited) {
        if (!visited.add(n)) return;
        for (int next : rooms.get(n)) dfs(rooms, next, visited);
    }
}
