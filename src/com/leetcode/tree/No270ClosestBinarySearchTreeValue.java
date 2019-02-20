package com.leetcode.tree;

public class No270ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        TreeNode lowerNode = lower(root, target), higherNode = higher(root, target);
        if (lowerNode == null) return higherNode.val;
        if (higherNode == null) return lowerNode.val;
        return target - lowerNode.val < higherNode.val - target ? lowerNode.val : higherNode.val;
    }

    private TreeNode lower(TreeNode root, double target) {
        if (root == null || root.val == target) return root;
        if (target < root.val) return lower(root.left, target);
        TreeNode lowerNode = lower(root.right, target);
        return lowerNode == null ? root : lowerNode;
    }


    private TreeNode higher(TreeNode root, double target) {
        if (root == null || root.val == target) return root;
        if (target > root.val) return higher(root.right, target);
        TreeNode higherNode = higher(root.left, target);
        return higherNode == null ? root : higherNode;
    }

    // https://www.cnblogs.com/grandyang/p/5237170.html
    public int closestValue2(TreeNode root, double target) {
        return helper(root, target).val;
    }

    private TreeNode helper(TreeNode root, double target) {
        if (root == null || root.val == target) return root;
        TreeNode a = root, t = target < a.val ? root.left : root.right;
        if (t == null) return root;
        TreeNode b = helper(t, target);

        return Math.abs(a.val - target) < Math.abs(b.val - target) ? a : b;
    }

    public int closestValue3(TreeNode root, double target) {
        double diff = Double.MAX_VALUE;
        int val = root.val;

        while (root != null) {
            if (diff > Math.abs(root.val - target)) {
                val = root.val;
                diff = Math.abs(root.val - target);
            }
            if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return val;
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
