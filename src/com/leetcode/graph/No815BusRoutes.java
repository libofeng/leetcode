package com.leetcode.graph;

import com.lintcode.geometry.Point;

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

    public int numBusesToDestination2(int[][] routes, int S, int T) {
        if (S==T) return 0;
        int N = routes.length;

        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < N; ++i) {
            Arrays.sort(routes[i]);
            graph.add(new ArrayList());
        }
        Set<Integer> seen = new HashSet();
        Set<Integer> targets = new HashSet();
        Queue<Point> queue = new ArrayDeque();

        // Build the graph.  Two buses are connected if
        // they share at least one bus stop.
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j)
                if (intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }

        // Initialize seen, queue, targets.
        // seen represents whether a node has ever been enqueued to queue.
        // queue handles our breadth first search.
        // targets is the set of goal states we have.
        for (int i = 0; i < N; ++i) {
            if (Arrays.binarySearch(routes[i], S) >= 0) {
                seen.add(i);
                queue.offer(new Point(i, 0));
            }
            if (Arrays.binarySearch(routes[i], T) >= 0)
                targets.add(i);
        }

        while (!queue.isEmpty()) {
            Point info = queue.poll();
            int node = info.x, depth = info.y;
            if (targets.contains(node)) return depth+1;
            for (Integer nei: graph.get(node)) {
                if (!seen.contains(nei)) {
                    seen.add(nei);
                    queue.offer(new Point(nei, depth+1));
                }
            }
        }

        return -1;
    }

    public boolean intersect(int[] A, int[] B) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) return true;
            if (A[i] < B[j]) i++; else j++;
        }
        return false;
    }
}
