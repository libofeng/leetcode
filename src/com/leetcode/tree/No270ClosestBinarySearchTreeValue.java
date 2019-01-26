package com.leetcode.tree;

public class No270ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        return helper(root, target, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int helper(TreeNode root, double target, int min, int max) {
        if (root == null) return Math.abs(min - target) < Math.abs(max - target) ? min : max;
        if (root.val == target) return root.val;

        return target < root.val ? helper(root.left, target, min, root.val) : helper(root.left, target, root.val, max);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);

        node2.left = node1;
        node3.left = node2;
        node3.right = node4;
        root.left = node3;
        root.right = node6;
        No270ClosestBinarySearchTreeValue solution = new No270ClosestBinarySearchTreeValue();
        int n = solution.closestValue(root, 2.5D);

        System.out.println("n = " + n);
    }
}
