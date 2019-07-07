package com.leetcode.contest.contest144;

import java.util.*;

public class No1110DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        final Set<Integer> set = new HashSet<>();
        for (int d : to_delete) set.add(d);

        final List<TreeNode> result = new ArrayList<>();
        root = dfs(result, set, root);
        if (root != null) result.add(root);

        return result;
    }

    private TreeNode dfs(List<TreeNode> result, Set<Integer> set, TreeNode root) {
        if (root == null) return null;

        root.left = dfs(result, set, root.left);
        root.right = dfs(result, set, root.right);
        if (set.contains(root.val)) {
            if (root.left != null) result.add(root.left);
            if (root.right != null) result.add(root.right);

            root.left = null;
            root.right = null;
            return null;
        }

        return root;
    }
}
