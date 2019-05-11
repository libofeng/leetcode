package com.leetcode.tree;

public class No549BinaryTreeLongestConsecutiveSequenceII {
    private int max = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;

        dfs(root);
        return max;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return new int[]{1, 1};
        int[] left = dfs(root.left), right = dfs(root.right);

        int asc = 1, desc = 1;
        if (left != null) {
            if (root.val + 1 == root.left.val) asc = Math.max(asc, left[0] + 1);
            else if (root.val - 1 == root.left.val) desc = Math.max(desc, left[1] + 1);
        }

        if (right != null) {
            if (root.val + 1 == root.right.val) asc = Math.max(asc, right[0] + 1);
            else if (root.val - 1 == root.right.val) desc = Math.max(desc, right[1] + 1);
        }

        max = Math.max(max, asc + desc - 1);
        return new int[]{asc, desc};
    }
}
