package com.lintcode.tree;

public class No900ClosestBinarySearchTreeValue {
    /**
     * @param root:   the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;

        TreeNode lowerNode = lowerBound(root, target);
        TreeNode upperNode = upperBound(root, target);

        if (lowerNode == null) return upperNode.val;

        if (upperNode == null) return lowerNode.val;

        if (target - lowerNode.val > upperNode.val - target) return upperNode.val;

        return lowerNode.val;
    }

    // find the node with the largest value that smaller than target
    private TreeNode lowerBound(TreeNode root, double target) {
        if (root == null) return null;

        if (target <= root.val) return lowerBound(root.left, target);

        // root.val < target
        TreeNode lowerNode = lowerBound(root.right, target);
        if (lowerNode != null) return lowerNode;

        return root;
    }

    // find the node with the smallest value that larger than or equal to target
    private TreeNode upperBound(TreeNode root, double target) {
        if (root == null) return null;

        if (root.val < target) return upperBound(root.right, target);

        // root.val >= target
        TreeNode upperNode = upperBound(root.left, target);
        if (upperNode != null) return upperNode;

        return root;
    }
}
