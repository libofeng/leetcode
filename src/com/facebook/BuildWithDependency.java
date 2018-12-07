package com.facebook;

import java.util.*;

public class BuildWithDependency {
    List<String> build(String m, Map<String, List<String>> map) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Set<String> visiting = new HashSet<>();
        buildGraph(m, map, graph, inDegree, visiting);

        Queue<String> q = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : inDegree.entrySet()) if (entry.getValue() == 0) q.offer(entry.getKey());

        List<String> R = new LinkedList<>();
        while (!q.isEmpty()) {
            String M = q.poll();
            R.add(M);
            if (!graph.containsKey(M) || graph.get(M).isEmpty()) continue;

            for (String child : graph.get(M)) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) q.offer(child);
            }
        }

        return R;
    }

    private void buildGraph(String m, Map<String, List<String>> map, Map<String,
            List<String>> graph, Map<String, Integer> inDegree, Set<String> visiting) {

        if (visiting.contains(m)) throw new RuntimeException("Cyclic dependence");
        inDegree.putIfAbsent(m, 0);

        if (!map.containsKey(m) || map.get(m).isEmpty()) return;
        visiting.add(m);
        for (String s : map.get(m)) {
            graph.putIfAbsent(s, new LinkedList<>());
            graph.get(s).add(m);
            inDegree.put(m, inDegree.get(m) + 1);

            buildGraph(s, map, graph, inDegree, visiting);
        }
        visiting.remove(m);
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
