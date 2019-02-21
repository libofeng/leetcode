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
        return dfs(root, target).val;
    }

    private TreeNode dfs(TreeNode root, double target) {
        if (root == null || root.val == target) return root;

        TreeNode next = target < root.val ? root.left : root.right;
        if (next == null) return root;

        next = dfs(next, target);
        return Math.abs(root.val - target) < Math.abs(next.val - target) ? root : next;
    }

    public int closestValue3(TreeNode root, double target) {
        if (target == root.val) return root.val;

        int a = root.val;
        TreeNode next = target < root.val ? root.left : root.right;
        if (next == null) return a;

        int b = closestValue3(next, target);
        return Math.abs(target - a) < Math.abs(target - b) ? a : b;
    }

    public int closestValue4(TreeNode root, double target) {
        double diff = Double.MAX_VALUE;
        int val = root.val;

        TreeNode current = root;
        while (current != null) {
            if (target == current.val) return current.val;

            if (Math.abs(current.val - target) < diff) {
                diff = Math.abs(current.val - target);
                val = current.val;
            }

            if (target < current.val) current = current.left;
            else current = current.right;
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
