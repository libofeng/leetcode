package com.lintcode.topological;

import java.util.*;

public class No127TopologicalSorting {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    // BFS
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        final Map<DirectedGraphNode, Integer> inDegree = new HashMap<>();
        final Set<DirectedGraphNode> visited = new HashSet<>();
        for (DirectedGraphNode N : graph) findInDegree(N, inDegree, visited);

        final Queue<DirectedGraphNode> q = new LinkedList<>();
        for (Map.Entry<DirectedGraphNode, Integer> entry : inDegree.entrySet())
            if (entry.getValue() == 0) q.offer(entry.getKey());

        final ArrayList<DirectedGraphNode> R = new ArrayList<>();
        while (!q.isEmpty()) {
            DirectedGraphNode N = q.poll();
            R.add(N);
            if (N.neighbors == null) continue;
            for (DirectedGraphNode c : N.neighbors) {
                inDegree.put(c, inDegree.get(c) - 1);
                if (inDegree.get(c) == 0) q.offer(c);
            }
        }
        return R;
    }

    void findInDegree(DirectedGraphNode node, Map<DirectedGraphNode, Integer> inDegree, Set<DirectedGraphNode> visited) {
        if (visited.contains(node)) return;
        if (node.neighbors == null) return;

        visited.add(node);
        inDegree.putIfAbsent(node, 0);
        for (DirectedGraphNode N : node.neighbors) {
            inDegree.put(N, inDegree.getOrDefault(N, 0) + 1);
            findInDegree(N, inDegree, visited);
        }
    }


    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    // DFS
    public ArrayList<DirectedGraphNode> topSort2(ArrayList<DirectedGraphNode> graph) {
        final Stack<DirectedGraphNode> stack = new Stack<>();
        final Set<DirectedGraphNode> visited = new HashSet<>(), visiting = new HashSet<>();

        ArrayList<DirectedGraphNode> list = new ArrayList<>();
        for (DirectedGraphNode N : graph) if (!helper(N, stack, visiting, visited)) return list;

        while (!stack.isEmpty()) list.add(stack.pop());
        return list;
    }

    private boolean helper(DirectedGraphNode N, Stack<DirectedGraphNode> stack, Set<DirectedGraphNode> visiting, Set<DirectedGraphNode> visited) {

        if (visited.contains(N)) return true;
        if (visiting.contains(N)) return false;

        visited.add(N);
        visiting.add(N);

        if (N.neighbors != null) {
            for (DirectedGraphNode n : N.neighbors) if (!helper(n, stack, visiting, visited)) return false;
        }

        visiting.remove(N);
        stack.push(N);
        return true;
    }
}
