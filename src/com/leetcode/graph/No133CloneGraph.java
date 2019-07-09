package com.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class No133CloneGraph {
    public Node cloneGraph(Node node) {
        return clone(node, new HashMap<>());
    }

    private Node clone(Node node, Map<Node, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);

        Node N = new Node(node.val, new ArrayList<>());
        map.put(node, N);
        for (Node n : node.neighbors) N.neighbors.add(clone(n, map));

        return N;
    }
}
