package com.lintcode.topological;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No815CourseScheduleIV {
    List<List<Integer>> graph;
    int n, ways;
    int[] inDegree;
    boolean[] visited;

    /**
     * @param n: an integer, denote the number of courses
     * @param p: a list of prerequisite pairs
     * @return: return an integer,denote the number of topologicalsort
     */
    public int topologicalSortNumber(int n, int[][] p) {
        this.n = n;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new LinkedList<>());

        inDegree = new int[n];
        visited = new boolean[n];

        for (int[] edge : p) {
            inDegree[edge[0]]++;
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(0);
        return ways;
    }

    private void dfs(int level) {
        if (level == n) {
            ways++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0 && !visited[i]) {
                visited[i] = true;
                for (int cv : graph.get(i)) inDegree[cv]--;
                dfs(level + 1);
                for (int cv : graph.get(i)) inDegree[cv]++;
                visited[i] = false;
            }
        }
    }
}
