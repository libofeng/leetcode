package com.leetcode.graph.topologicl;

import java.util.*;

public class No210CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final int[] R = new int[numCourses];

        final int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) inDegree[edge[0]]++;

        final Queue<Integer> q = new LinkedList<>();
        for (int v = 0; v < numCourses; v++) if (inDegree[v] == 0) q.offer(v);

        int index = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            R[index++] = v;
            for (int[] edge : prerequisites) if (edge[1] == v && --inDegree[edge[0]] == 0) q.offer(edge[0]);
        }

        return index == numCourses ? R : new int[0];
    }

    // use Adjacency list to optimize Kahn's Algorithms
    public int[] findOrder11(int numCourses, int[][] prerequisites) {
        final int[] R = new int[numCourses];

        final int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) inDegree[edge[0]]++;

        final List<List<Integer>> graph = new ArrayList<>();
        for(int v = 0; v < numCourses; v++) graph.add(new ArrayList<>());
        for(int[] edge : prerequisites) graph.get(edge[1]).add(edge[0]);

        final Queue<Integer> q = new LinkedList<>();
        for (int v = 0; v < numCourses; v++) if (inDegree[v] == 0) q.offer(v);

        int index = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            R[index++] = v;
            for (int av : graph.get(v)) if (--inDegree[av] == 0) q.offer(av);
        }

        return index == numCourses ? R : new int[0];
    }

    //-----------------------------

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        final int[] FAIL = new int[0];
        if (numCourses <= 0) return FAIL;
        if (prerequisites == null || prerequisites.length == 0) {
            int[] R = new int[numCourses];
            for (int v = 0; v < numCourses; v++) R[v] = v;
            return R;
        }

        final boolean[] visited = new boolean[numCourses];
        final boolean[] visiting = new boolean[numCourses];

        final Stack<Integer> stack = new Stack<>();
        for (int v = 0; v < numCourses; v++)
            if (!visited[v] && !dfs(v, prerequisites, visited, visiting, stack)) return FAIL;

        int[] R = new int[numCourses];
        for (int i = 0; i < numCourses; i++) R[i] = stack.pop();
        return R;
    }

    private boolean dfs(int v, int[][] p, boolean[] visited, boolean[] visiting, Stack<Integer> stack) {
        if (visited[v]) return true;

        visiting[v] = true;
        visited[v] = true;

        for (int[] edge : p)
            if (edge[1] == v && (visiting[edge[0]] || !dfs(edge[0], p, visited, visiting, stack))) return false;

        visiting[v] = false;
        stack.push(v);
        return true;
    }

    // use Adjacency list to optimize Tarjan's Algorithms
    public int[] findOrder22(int numCourses, int[][] prerequisites) {
        final int[] FAIL = new int[0];
        if (numCourses <= 0) return FAIL;
        if (prerequisites == null || prerequisites.length == 0) {
            int[] R = new int[numCourses];
            for (int v = 0; v < numCourses; v++) R[v] = v;
            return R;
        }

        final boolean[] visited = new boolean[numCourses];
        final boolean[] visiting = new boolean[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int v = 0; v < numCourses; v++) graph.add(new ArrayList<>());
        for (int[] edge : prerequisites) graph.get(edge[1]).add(edge[0]);

        final Stack<Integer> stack = new Stack<>();
        for (int v = 0; v < numCourses; v++) if (!visited[v] && !dfs(v, graph, visited, visiting, stack)) return FAIL;

        int[] R = new int[numCourses];
        for (int i = 0; i < numCourses; i++) R[i] = stack.pop();
        return R;
    }

    private boolean dfs(int v, List<List<Integer>> graph, boolean[] visited, boolean[] visiting, Stack<Integer> stack) {
        if (visited[v]) return true;

        visiting[v] = true;
        visited[v] = true;

        for (int av : graph.get(v)) if (visiting[av] || !dfs(av, graph, visited, visiting, stack)) return false;

        visiting[v] = false;
        stack.push(v);
        return true;
    }

}
