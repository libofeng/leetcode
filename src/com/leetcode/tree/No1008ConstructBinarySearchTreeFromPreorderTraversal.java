package com.leetcode.tree;

public class No1008ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) return null;

        final int n = nums[lo++];
        final TreeNode root = new TreeNode(n);

        int mid = lo;
        while (mid <= hi) {
            if (nums[mid] > n) break;
            mid++;
        }
        root.left = build(nums, lo, mid - 1);
        root.right = build(nums, mid, hi);

        return root;
    }
}
