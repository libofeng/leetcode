package com.leetcode.contest.biweekly.contest7;

import java.util.*;

public class No1168OptimizeWaterDistributionInAVillage {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        final List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : pipes) {
            graph.get(e[0] - 1).add(new int[]{e[1] - 1, e[2]});
            graph.get(e[1] - 1).add(new int[]{e[0] - 1, e[2]});
        }

        final Set<Integer> visited = new HashSet<>();
        final Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < n; i++) pq.offer(new int[]{i, wells[i]});

        int costs = 0;
        while (!pq.isEmpty()) {
            int h = pq.peek()[0], cost = pq.poll()[1];
            if (!visited.add(h)) continue;

            costs += cost;
            for (int[] next : graph.get(h)) pq.offer(next);
        }

        return visited.size() == n ? costs : -1;
    }

    // assume there another virtual house labeled "n+1"
    // treat wells[i] as the weight of the edge connect house i and n+1
    // then we can use Prim and Kruskal algorithm
    public int minCostToSupplyWater2(int n, int[] wells, int[][] pipes) {
        final List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0;i<=n;i++) graph.add(new ArrayList<>());
        for(int[] e : pipes){
            graph.get(e[0] - 1).add(new int[]{e[1] - 1, e[2]});
            graph.get(e[1] - 1).add(new int[]{e[0] - 1, e[2]});
        }
        for(int i = 0;i<n;i++) graph.get(n).add(new int[]{i, wells[i]});

        final Set<Integer> visited = new HashSet<>();
        final Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{n, 0});

        int costs = 0;
        while(!pq.isEmpty()){
            int h = pq.peek()[0], cost = pq.poll()[1];
            if(!visited.add(h)) continue;

            costs += cost;
            for(int[] next : graph.get(h)) pq.offer(next);
        }

        return visited.size() == n + 1 ? costs : -1;
    }


}
