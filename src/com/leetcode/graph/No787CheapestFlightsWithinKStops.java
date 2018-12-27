package com.leetcode.graph;

import java.util.*;

public class No787CheapestFlightsWithinKStops {

//    1. 通过visited集合，记录当前路径中已经访问过的城市，本条路径中将不再访问
//    2. 如果当前路径的距离已经大于之前发现的最短距离，则不用再继续向下搜索
//    3. 中转次数一旦超过也不需要再向下搜索

    // http://www.cnblogs.com/grandyang/p/9109981.html
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) return 0;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        if (graph.get(src).isEmpty()) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});

        int minPrice = Integer.MAX_VALUE;
        while (!q.isEmpty() && K-- >= 0) {
            int size = q.size();
            while (size-- > 0) {
                int[] stop = q.poll();
                for (int[] flight : graph.get(stop[0])) {
                    int nextPrice = stop[1] + flight[1];
                    if (nextPrice >= minPrice) continue;

                    if (flight[0] == dst) minPrice = nextPrice;
                    else q.offer(new int[]{flight[0], nextPrice});
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

    // Bellman-Ford
    public int findCheapestPrice4(int n, int[][] flights, int src, int dst, int k) {
        int INF = 0x3F3F3F3F;
        int[] cost = new int[n];
        Arrays.fill(cost, INF);
        cost[src] = 0;
        int ans = cost[dst];
        for (int i = k; i >= 0; i--) {
            int[] cur = new int[n];
            Arrays.fill(cur, INF);
            for (int[] flight : flights) {
                cur[flight[1]] = Math.min(cur[flight[1]], cost[flight[0]] + flight[2]);
            }
            cost = cur;
            ans = Math.min(ans, cost[dst]);
        }
        return ans == INF ? -1 : ans;
    }

    //    ----------------------
    private class City implements Comparable<City> {
        int id;
        int costFromSrc;
        int stopFromSrc;

        public City(int id, int costFromSrc, int stopFromSrc) {
            this.id = id;
            this.costFromSrc = costFromSrc;
            this.stopFromSrc = stopFromSrc;
        }

        public boolean equals(City c) {
            if (c instanceof City)
                return this.id == c.id;
            return false;
        }

        public int compareTo(City c) {
            return this.costFromSrc - c.costFromSrc;
        }
    }

    // Dijkstra's
    // https://blog.csdn.net/qq_26410101/article/details/80910474
    public int findCheapestPrice5(int n, int[][] flights, int src, int dst, int K) {
        int[][] srcToDst = new int[n][n];
        for (int i = 0; i < flights.length; i++)
            srcToDst[flights[i][0]][flights[i][1]] = flights[i][2];

        PriorityQueue<City> minHeap = new PriorityQueue();
        minHeap.offer(new City(src, 0, 0));

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        int[] stop = new int[n];
        Arrays.fill(stop, Integer.MAX_VALUE);
        stop[src] = 0;

        while (!minHeap.isEmpty()) {
            City curCity = minHeap.poll();
            if (curCity.id == dst) return curCity.costFromSrc;
            if (curCity.stopFromSrc == K + 1) continue;
            int[] nexts = srcToDst[curCity.id];
            for (int i = 0; i < n; i++) {
                if (nexts[i] != 0) {
                    int newCost = curCity.costFromSrc + nexts[i];
                    int newStop = curCity.stopFromSrc + 1;
                    if (newCost < cost[i]) {
                        minHeap.offer(new City(i, newCost, newStop));
                        cost[i] = newCost;
                    } else if (newStop < stop[i]) {
                        minHeap.offer(new City(i, newCost, newStop));
                        stop[i] = newStop;
                    }
                }
            }
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }


    // todo: DP

    public static void main(String[] args) {
        No787CheapestFlightsWithinKStops solution = new No787CheapestFlightsWithinKStops();
        int min = solution.findCheapestPrice(5, new int[][]{{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}}, 2, 1, 1);
        System.out.println("min = " + min);
    }
}
