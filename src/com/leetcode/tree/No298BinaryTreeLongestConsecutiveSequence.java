package com.leetcode.tree;

public class No298BinaryTreeLongestConsecutiveSequence {
    private int maxLen = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;

        dfs(root, root.left, 1);
        dfs(root, root.right, 1);

        return maxLen;
    }

    private void dfs(TreeNode parent, TreeNode node, int len) {
        if (node == null) return;

        if (node.val == parent.val + 1) maxLen = Math.max(maxLen, ++len);
        else len = 1;

        dfs(node, node.left, len);
        dfs(node, node.right, len);
    }

    // without global variable
    public int longestConsecutive2(TreeNode root) {
        if (root == null) return 0;

        int left = dfs2(root, root.left, 1), right = dfs2(root, root.right, 1);
        return Math.max(left, right);
    }

    private int dfs2(TreeNode parent, TreeNode node, int len) {
        if (node == null) return len;

        int nextLen = (node.val == parent.val + 1) ? (len + 1) : 1;
        return Math.max(len, Math.max(dfs2(node, node.left, nextLen), dfs2(node, node.right, nextLen)));
    }
}
