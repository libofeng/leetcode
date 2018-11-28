package com.lintcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class No137CloneGraph {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        final Map<Integer, UndirectedGraphNode> map = new HashMap<>();

        return clone(node, map);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);

        UndirectedGraphNode N = new UndirectedGraphNode(node.label);
        N.neighbors = new ArrayList<>();
        map.put(node.label, N);

        for (UndirectedGraphNode n : node.neighbors) N.neighbors.add(clone(n, map));
        return N;
    }
}
