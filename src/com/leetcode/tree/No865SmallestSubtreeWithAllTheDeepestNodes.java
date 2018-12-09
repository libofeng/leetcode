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
    private int maxDepth;
    private TreeNode p;

    public TreeNode subtreeWithAllDeepest2(TreeNode root) {
        if (root == null) return root;
        depth(root, 0);
        return p;
    }

    private int depth(TreeNode root, int depth) {
        if (root == null) return depth;
        int l = depth(root.left, depth + 1), r = depth(root.right, depth + 1);

        maxDepth = Math.max(maxDepth, Math.max(l, r));
        if (l == r && l == maxDepth) p = root;
        return Math.max(l, r);
    }
}
