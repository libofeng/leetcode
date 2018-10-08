package com.leetcode.tree;

public class No108ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int start, int end) {
        if (start > end || start < 0 || end >= nums.length) return null;
        else if (start == end) return new TreeNode(nums[start]);

        int mid = start + (end - start) / 2;
        final TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, start, mid - 1);
        node.right = build(nums, mid + 1, end);

        return node;
    }
}
