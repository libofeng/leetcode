package com.company.facebook;

import java.util.*;

public class BuildWithDependency {
    // No need to use topological sort!!!
    List<String> build(String m, Map<String, List<String>> dependencies) {
        final Set<String> visited = new HashSet<>(), visiting = new HashSet<>();
        final Stack<String> stack = new Stack<>();
        if (!dfs(dependencies, visited, visiting, stack, m)) throw new RuntimeException("Cycle detected.");

        return new ArrayList<>(stack);
    }

    private boolean dfs(Map<String, List<String>> graph, Set<String> visited, Set<String> visiting, Stack<String> stack, String n) {
        if (visited.contains(n)) return true;
        visiting.add(n);

        if (graph.containsKey(n)) {
            for (String next : graph.get(n))
                if (visiting.contains(next) || !dfs(graph, visited, visiting, stack, next)) return false;
        }

        visiting.remove(n);
        visited.add(n);
        stack.push(n);
        return true;
    }

    public static void main(String[] args) {
        BuildWithDependency solution = new BuildWithDependency();

        Map<String, List<String>> map = new HashMap<>();
        map.putIfAbsent("A", Arrays.asList("B", "C"));
        map.putIfAbsent("B", Collections.singletonList("D"));
        map.putIfAbsent("C", Arrays.asList("D", "E"));
        map.putIfAbsent("D", new ArrayList<>());
//        map.putIfAbsent("D", Collections.singletonList("A"));
        map.putIfAbsent("F", Collections.singletonList("D"));
        map.putIfAbsent("G", Collections.singletonList("A"));

        List<String> order = solution.build("A", map);
        System.out.println("order = " + order);
    }
}
