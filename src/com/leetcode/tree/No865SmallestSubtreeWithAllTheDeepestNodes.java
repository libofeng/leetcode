package com.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class No865SmallestSubtreeWithAllTheDeepestNodes {
    private Map<Integer, Integer> heights = new HashMap<>();


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root);
    }

    // O(H)
    private TreeNode helper(TreeNode root) {
        if (root == null) return null;

        int hl = heights(root.left), hr = heights(root.right);
        if (hl == hr) return root;
        return hl > hr ? helper(root.left) : helper(root.right);
    }

    // O(N)
    private int heights(TreeNode root) {
        if (root == null) return 0;
        if (heights.containsKey(root.val)) return heights.get(root.val);

        int hl = heights(root.left), hr = heights(root.right);
        int h = Math.max(hl, hr) + 1;
        heights.put(root.val, h);
        return h;
    }

    // ---------------------------
    private TreeNode lca;
    private int maxDepth = 0;

    public TreeNode subtreeWithAllDeepest2(TreeNode root) {
        maxDepth(root, 0);

        return lca;
    }

    private int maxDepth(TreeNode root, int d) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, d);
            return d;
        }

        int left = maxDepth(root.left, d + 1), right = maxDepth(root.right, d + 1);
        if (left == maxDepth && right == maxDepth) lca = root;

        return Math.max(left, right);
    }
}
