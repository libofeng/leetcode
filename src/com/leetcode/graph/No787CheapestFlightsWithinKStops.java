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
        if (src == dst) return 0;
        final Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] f : flights) graph.get(f[0]).add(new int[]{f[1], f[2]});

        final Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{src, 0, 0});
        final boolean[] visiting = new boolean[n];

        dfs(graph, visiting, dst, src, 0, K);

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    private int minCost = Integer.MAX_VALUE;

    private void dfs(Map<Integer, List<int[]>> graph, boolean[] visting, int dst, int city, int cost, int k) {
        if (visting[city] || cost >= minCost || k < 0) return;

        visting[city] = true;
        for (int[] next : graph.get(city)) {
            int nextCity = next[0], nextCost = cost + next[1];
            if (dst == nextCity) minCost = Math.min(minCost, nextCost);
            else dfs(graph, visting, dst, nextCity, nextCost, k - 1);
        }
        visting[city] = false;
    }

    public int findCheapestPrice3(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) return 0;
        final List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] f : flights) graph.get(f[0]).add(new int[]{f[1], f[2]});

        final boolean[] visiting = new boolean[n];
        final Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{src, 0, 0});

        int minCost = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            int[] flight = stack.peek();
            int city = flight[0], cost = flight[1], stops = flight[2];
            if (visiting[city]) {
                stack.pop();
                visiting[city] = false;
                continue;
            }

            visiting[city] = true;
            for (int[] f : graph.get(city)) {
                int nextCity = f[0], price = f[1], nextCost = cost + price;
                if (nextCity == dst) {
                    minCost = Math.min(minCost, nextCost);
                    continue;
                } else if (visiting[nextCity] || stops >= K || nextCost >= minCost) continue;

                stack.push(new int[]{nextCity, nextCost, stops + 1});
            }
        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    // Bellman-Ford

    // BF runs V-1 iterations since that's the longest possible path from src to dest - one that uses every vertex.
    // In this problem, since the longest path is given as K+1, you only need to run it that many iterations.

    // See https://en.wikipedia.org/wiki/Bellman–Ford_algorithm
    //        "After i repetitions of for loop... if there is a path from s to u with at most i edges,
    //        then Distance(u) is at most the length of the shortest path from s to u with at most i edges."
    public int findCheapestPrice4(int n, int[][] flights, int src, int dst, int K) {
        final int INF = 1000007;
        int[] cost = new int[n];
        Arrays.fill(cost, INF);
        cost[src] = 0;

        int minCost = INF;
        for (int i = 0; i <= K; i++) {
            int[] current = new int[n];
            Arrays.fill(current, INF);
            for (int[] f : flights) current[f[1]] = Math.min(current[f[1]], cost[f[0]] + f[2]);
            cost = current;
            minCost = Math.min(minCost, cost[dst]);
        }

        return minCost == INF ? -1 : minCost;
    }

    // Bellman Ford 2
    public int findCheapestPrice5(int n, int[][] flights, int src, int dst, int K) {
        int max = (int) 1e9 + 7;
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) cost[i][j] = max;

        cost[src][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], w = flight[2];
                for (int k = 1; k < n; k++) {
                    if (cost[from][k - 1] + w < cost[to][k])
                        cost[to][k] = cost[from][k - 1] + w;
                }
            }
        }

        int min = max;
        for (int i = 0; i <= K + 1; i++) {
            if (i < cost[dst].length) min = Math.min(min, cost[dst][i]);
        }
        return min == max ? -1 : min;
    }

    //    ----------------------
    private class City implements Comparable<City> {
        int id;
        int cost;
        int stops;

        public City(int id, int cost, int stops) {
            this.id = id;
            this.cost = cost;
            this.stops = stops;
        }

        public int compareTo(City c) {
            return this.cost - c.cost;
        }
    }

    // Dijkstra's
    // https://blog.csdn.net/qq_26410101/article/details/80910474
    public int findCheapestPrice6(int n, int[][] flights, int src, int dst, int K) {
        int[][] srcToDst = new int[n][n];
        for (int i = 0; i < flights.length; i++)
            srcToDst[flights[i][0]][flights[i][1]] = flights[i][2];

        PriorityQueue<City> minHeap = new PriorityQueue<>();
        minHeap.offer(new City(src, 0, 0));

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        int[] stop = new int[n];
        Arrays.fill(stop, Integer.MAX_VALUE);
        stop[src] = 0;

        while (!minHeap.isEmpty()) {
            City curCity = minHeap.poll();
            if (curCity.id == dst) return curCity.cost;
            if (curCity.stops == K + 1) continue;
            int[] nexts = srcToDst[curCity.id];
            for (int i = 0; i < n; i++) {
                if (nexts[i] != 0) {
                    int newCost = curCity.cost + nexts[i];
                    int newStop = curCity.stops + 1;
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

    // Dijkstra's 2
    public int findCheapestPrice7(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) return 0;
        final List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] f : flights) graph.get(f[0]).add(new int[]{f[1], f[2]});

        final Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        };

        final PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
        pq.offer(new int[]{src, 0, 0});

        final boolean[] visited = new boolean[n];
        while (!pq.isEmpty()) {
            int[] flight = pq.poll();
            int city = flight[0], cost = flight[1], stops = flight[2];
            if (dst == city) return cost;
            if (stops > K) continue;

            visited[city] = true;
            for (int[] f : graph.get(city)) if (!visited[f[0]]) pq.offer(new int[]{f[0], f[1] + cost, stops + 1});
        }

        return -1;
    }


    // DP
    public int findCheapestPrice8(int n, int[][] flights, int src, int dst, int K) {
        //dp[i][j] denotes the cheapest price within i-1 stops, stop in j city
        long[][] dp = new long[K + 2][n];
        for (long[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        dp[0][src] = 0;
        for (int i = 1; i < K + 2; i++) {
            dp[i][src] = 0;
            for (int[] f : flights) {
                dp[i][f[1]] = Math.min(dp[i][f[1]], dp[i - 1][f[0]] + f[2]);
            }
        }
        return dp[K + 1][dst] == Integer.MAX_VALUE ? -1 : (int) dp[K + 1][dst];
    }


    public static void main(String[] args) {
        No787CheapestFlightsWithinKStops solution = new No787CheapestFlightsWithinKStops();
        int min = solution.findCheapestPrice(5, new int[][]{{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}}, 2, 1, 1);
        System.out.println("min = " + min);

        No787CheapestFlightsWithinKStops solution2 = new No787CheapestFlightsWithinKStops();
        int min2 = solution2.findCheapestPrice4(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 3, 100}, {0, 3, 500}}, 0, 3, 1);
        System.out.println("min2 = " + min2);

        No787CheapestFlightsWithinKStops solution3 = new No787CheapestFlightsWithinKStops();
        int min3 = solution3.findCheapestPrice3(7, new int[][]{{0, 1, 3}, {0, 2, 1}, {2, 6, 2}, {6, 3, 1}, {1, 3, 2}, {3, 5, 5}, {3, 4, 1}, {4, 5, 1}}, 0, 5, 3);
        System.out.println("min3 = " + min3);

        No787CheapestFlightsWithinKStops solution31 = new No787CheapestFlightsWithinKStops();
        int min31 = solution31.findCheapestPrice(7, new int[][]{{0, 1, 3}, {0, 2, 1}, {2, 6, 2}, {6, 3, 1}, {1, 3, 2}, {3, 5, 5}, {3, 4, 1}, {4, 5, 1}}, 0, 5, 3);
        System.out.println("min31 = " + min31);
    }
}
