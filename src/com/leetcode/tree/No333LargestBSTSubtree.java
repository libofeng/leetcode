package com.leetcode.tree;

public class No333LargestBSTSubtree {
    private int maxSize = 0;

    public int largestBSTSubtree(TreeNode root) {
        postOrder(root);

        return maxSize;
    }

    private int[] postOrder(TreeNode root) {
        if (root == null) return new int[]{0, 0, 0};

        int[] left = postOrder(root.left), right = postOrder(root.right);
        if (left == null || right == null) return null;

        int size = left[0] + right[0] + 1;

        if (left[0] > 0 && root.val <= left[2]) return null;
        if (right[0] > 0 && root.val >= right[1]) return null;

        maxSize = Math.max(maxSize, size);
        return new int[]{size, left[0] == 0 ? root.val : left[1], right[0] == 0 ? root.val : right[2]};
    }
}
