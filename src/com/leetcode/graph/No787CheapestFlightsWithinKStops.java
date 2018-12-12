package com.leetcode.graph;

import java.util.*;

public class No787CheapestFlightsWithinKStops {

//    1. 通过visited集合，记录当前路径中已经访问过的城市，本条路径中将不再访问
//    2. 如果当前路径的距离已经大于之前发现的最短距离，则不用再继续向下搜索
//    3. 中转次数一旦超过也不需要再向下搜索

    // http://www.cnblogs.com/grandyang/p/9109981.html
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        final Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();

        int minPrice = Integer.MAX_VALUE;
        q.offer(new int[]{src, 0});
        while (!q.isEmpty() && K-- >= 0) {
            int size = q.size();
            while (size-- > 0) {
                int[] stop = q.poll();
                for (int[] next : graph.get(stop[0])) {
                    if (next[1] + stop[1] >= minPrice) continue;

                    if (next[0] == dst) minPrice = Math.min(minPrice, next[1] + stop[1]);
                    q.offer(new int[]{next[0], next[1] + stop[1]});
                }
            }
        }

        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }

    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {
        final Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        final boolean[] visited = new boolean[n];
        visited[src] = true;
        dfs(graph, visited, new int[]{src, 0}, dst, K);
        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }

    private int minPrice = Integer.MAX_VALUE;

    private void dfs(Map<Integer, List<int[]>> graph, boolean[] visited, int[] src, int dst, int k) {
        if (k < 0) return;

        for (int[] next : graph.get(src[0])) {
            if (next[1] + src[1] >= minPrice) continue;
            if (visited[next[0]]) continue;

            if (next[0] == dst) minPrice = Math.min(minPrice, next[1] + src[1]);
            visited[next[0]] = true;
            dfs(graph, visited, new int[]{next[0], next[1] + src[1]}, dst, k - 1);
            visited[next[0]] = false;
        }
    }

    public int findCheapestPrice3(int n, int[][] flights, int src, int dst, int K) {
        final Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        final Stack<int[]> stack = new Stack<>();
        Map<Integer, Integer> min = new HashMap<>();
        min.put(src, 0);
        stack.push(new int[]{src, 0, 0});

        int minPrice = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            int[] prev = stack.pop();

            for (int[] next : graph.get(prev[0])) {
                if (next[0] == dst) {
                    minPrice = Math.min(minPrice, next[1] + prev[1]);
                    continue;
                }
                if (prev[2] == K) continue;
                if (min.containsKey(next[0]) && min.get(next[0]) <= next[1] + prev[1]) continue;
                min.put(next[0], next[1] + prev[1]);

                stack.push(new int[]{next[0], next[1] + prev[1], prev[2] + 1});
            }

        }

        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }

    // todo: DP

    public static void main(String[] args) {
        No787CheapestFlightsWithinKStops solution = new No787CheapestFlightsWithinKStops();
        int min = solution.findCheapestPrice(5, new int[][]{{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}}, 2, 1, 1);
        System.out.println("min = " + min);
    }
}
