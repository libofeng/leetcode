package com.leetcode.graph.topological;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No207CourseSchedule {
    // Kahn's Algorithms, BFS based
    // Time Complexity - O(VE)， Space Complexity - O(V)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false;
        else if (prerequisites == null || prerequisites.length == 0) return true;

        final int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) inDegree[edge[0]]++;

        final Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) if (inDegree[i] == 0) q.offer(i);

        final List<Integer> R = new ArrayList<>();
        while (!q.isEmpty()) {
            int source = q.poll();
            R.add(source);

            for (int[] edge : prerequisites) {
                if (edge[1] == source) if (--inDegree[edge[0]] == 0) q.offer(edge[0]);
            }
        }

        return R.size() == numCourses;
    }

    // use Adjacency list to optimize Kahn's Algorithms
    // Time Complexity - O(V+E)，Space Complexity - O(VE)
    public boolean canFinish11(int numCourses, int[][] prerequisites) {
        final List<List<Integer>> graph = new ArrayList<>();
        final int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] d : prerequisites) {
            graph.get(d[1]).add(d[0]);
            inDegree[d[0]]++;
        }

        final Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (inDegree[i] == 0) q.offer(i);

        int total = 0;
        while (!q.isEmpty()) {
            int c = q.poll();
            total++;

            for (int next : graph.get(c)) if (--inDegree[next] == 0) q.offer(next);
        }

        return total == numCourses;
    }


    //-----------------------------

    // Tarjan's Algorithms - DFS based
    // Time Complexity - O(V+E)，Space Complexity - O(V)
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false;
        if (prerequisites == null || prerequisites.length == 0) return true;

        final boolean[] visited = new boolean[numCourses];
        final boolean[] visiting = new boolean[numCourses];

        for (int v = 0; v < numCourses; v++) if (!visited[v] && !dfs(v, prerequisites, visited, visiting)) return false;
        return true;
    }

    private boolean dfs(int v, int[][] p, boolean[] visited, boolean[] visiting) {
        visiting[v] = true;
        visited[v] = true;

        for (int[] edge : p)
            if (edge[1] == v && (visiting[edge[0]] || !dfs(edge[0], p, visited, visiting))) return false;

        visiting[v] = false;
        return true;
    }


    // use Adjacency list to optimize Tarjan's Algorithms
    // Time Complexity - O(V+E)，Space Complexity - O(VE)
    // https://www.youtube.com/watch?v=QnWDU1wcsPA
    public boolean canFinish22(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false;
        if (prerequisites == null || prerequisites.length == 0) return true;

        final List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] p : prerequisites) graph.get(p[1]).add(p[0]);

        final boolean[] visited = new boolean[numCourses], visiting = new boolean[numCourses];

        for (int v = 0; v < numCourses; v++) if (!dfs(v, graph, visited, visiting)) return false;
        return true;
    }

    private boolean dfs(int v, List<List<Integer>> graph, boolean[] visited, boolean[] visiting) {
        if (visited[v]) return true;

        visiting[v] = true;
        for (int dv : graph.get(v)) if (visiting[dv] || !dfs(dv, graph, visited, visiting)) return false;
        visiting[v] = false;
        visited[v] = true;

        return true;
    }
}
