package com.leetcode.tree;

public class No979DistributeCoinsInBinaryTree {
    private int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int count = 1, coins = root.val;
        int[] left = dfs(root.left), right = dfs(root.right);
        count += left[0] + right[0];
        coins += left[1] + right[1];

        moves += Math.abs(count - coins);
        return new int[]{count, coins};
    }

    public int distributeCoins2(TreeNode root) {
        dfs2(root);
        return moves;
    }

    private int dfs2(TreeNode root) {
        if (root == null) return 0;

        int left = dfs2(root.left), right = dfs2(root.right), current = root.val - 1;
        moves += Math.abs(left + right + current);

        return left + right + current;
    }
}
