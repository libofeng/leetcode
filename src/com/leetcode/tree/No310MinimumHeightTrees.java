package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No310MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        final List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) if (graph.get(i).size() == 1) list.add(i);

        while (n > 2) {
            n -= list.size();

            List<Integer> next = new ArrayList<>();
            for (Integer node : list) {
                int adj = graph.get(node).remove(0);
                graph.get(adj).remove(node);

                if (graph.get(adj).size() == 1) next.add(adj);
            }

            list = next;
        }

        return list;
    }
}
