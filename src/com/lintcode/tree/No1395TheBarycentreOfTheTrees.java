package com.lintcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No1395TheBarycentreOfTheTrees {
    /**
     * @param x: The vertexes of the edges
     * @param y: The vertexes of the edges
     * @return: Return the index of barycentre
     */
    private final int N = 100000;
    private int treeSize, minGlobalSubtreeSize, gravity = 0;

    public int getBarycentre(int[] x, int[] y) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            graph.putIfAbsent(x[i], new ArrayList<>());
            graph.putIfAbsent(y[i], new ArrayList<>());

            graph.get(x[i]).add(y[i]);
            graph.get(y[i]).add(x[i]);
        }
        treeSize = graph.size();
        minGlobalSubtreeSize = treeSize;

        final int[] dp = new int[N + 1];
        dfs(graph, dp, 1, 0);
        return gravity;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int[] dp, int root, int prevRoot) {
        dp[root] = 1;
        int maxSubtreeSize = 0;
        for (int subRoot : graph.get(root)) {
            if (subRoot == prevRoot) continue;

            dfs(graph, dp, subRoot, root);
            dp[root] += dp[subRoot];
            maxSubtreeSize = Math.max(maxSubtreeSize, dp[subRoot]);
        }
        maxSubtreeSize = Math.min(maxSubtreeSize, treeSize - dp[root]);
        if (maxSubtreeSize < minGlobalSubtreeSize || (maxSubtreeSize == minGlobalSubtreeSize && root < gravity)) {
            minGlobalSubtreeSize = maxSubtreeSize;
            gravity = root;
        }
    }
}
