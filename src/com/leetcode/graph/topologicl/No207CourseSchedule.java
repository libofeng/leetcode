package com.leetcode.graph.topologicl;

import java.util.*;

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
        if (numCourses <= 0) return false;
        else if (prerequisites == null || prerequisites.length == 0) return true;

        final List<List<Integer>> graph = new ArrayList<>();
        for (int v = 0; v < numCourses; v++) graph.add(new ArrayList<>());
        for (int[] e : prerequisites) graph.get(e[1]).add(e[0]);

        final int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) inDegree[edge[0]]++;

        final Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) if (inDegree[i] == 0) q.offer(i);

        final List<Integer> R = new ArrayList<>();
        while (!q.isEmpty()) {
            int source = q.poll();
            R.add(source);
            for (int v : graph.get(source)) if (--inDegree[v] == 0) q.offer(v);
        }

        return R.size() == numCourses;
    }


    //-----------------------------

    // Tarjan's Algorithms - DFS based
    // Time Complexity - O(VE)，Space Complexity - O(V)
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
    public boolean canFinish22(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false;
        if (prerequisites == null || prerequisites.length == 0) return true;

        final List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] p : prerequisites) graph.get(p[1]).add(p[0]);

        final boolean[] visited = new boolean[numCourses];
        final Stack<Integer> stack = new Stack<>();

        for (int v = 0; v < numCourses; v++) if (!dfs(v, graph, visited, stack)) return false;
        return true;
    }

    private boolean dfs(int v, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int dv : graph.get(v)) if (visited[dv] || !dfs(dv, graph, visited, stack)) return false;
        visited[v] = false;

        stack.push(v);
        return true;
    }
}
