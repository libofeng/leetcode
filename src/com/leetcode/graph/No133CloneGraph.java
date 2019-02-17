package com.leetcode.graph;

import java.util.HashMap;
import java.util.Map;

public class No133CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return clone(node, map);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map){
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);

        UndirectedGraphNode N = new UndirectedGraphNode(node.label);
        map.put(node, N);
        for(UndirectedGraphNode n : node.neighbors) N.neighbors.add(clone(n, map));

        return N;
    }
}
