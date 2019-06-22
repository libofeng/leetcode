package com.leetcode.tree;

public class No250CountUnivalueSubtrees {
    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root != null) dfs(root, root.val);
        return count;
    }

    private Integer dfs(TreeNode root, int parentVal) {
        if (root == null) return parentVal;
        if (root.left == null && root.right == null) {
            count++;
            return root.val;
        }

        int left = dfs(root.left, root.val), right = dfs(root.right, root.val);
        if (root.val != left || root.val != right) return parentVal - 1;

        count++;
        return root.val;
    }
}
