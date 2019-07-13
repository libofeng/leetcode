package com.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class No508MostFrequentSubtreeSum {
    private final Map<Integer, Integer> map = new HashMap<>();
    private int maxFrequent = 0, maxFrequentCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);

        final int[] result = new int[maxFrequentCount];
        int index = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == maxFrequent) result[index++] = e.getKey();
        }

        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int sum = root.val + dfs(root.left) + dfs(root.right);
        int frequent = map.getOrDefault(sum, 0) + 1;
        map.put(sum, frequent);
        if (maxFrequent == frequent) maxFrequentCount++;
        else if (frequent > maxFrequent) {
            maxFrequent = frequent;
            maxFrequentCount = 1;
        }

        return sum;
    }
}
