package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class No272ClosestBinarySearchTreeValueII {
    // https://www.cnblogs.com/yrbbest/p/5031304.html

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        final Stack<TreeNode> stack = new Stack<>();
        final LinkedList<Integer> list = new LinkedList<>();

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if (list.size() < k) list.addLast(current.val);
            else {
                if (target < list.getFirst()) break;
                if (Math.abs(current.val - target) > Math.abs(list.getFirst() - target)) break;
                list.removeFirst();
                list.addLast(current.val);
            }
            current = current.right;
        }

        return list;
    }

    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
        final LinkedList<Integer> list = new LinkedList<>();
        inorder(root, target, k, list);

        return list;
    }

    private void inorder(TreeNode root, double target, int k, LinkedList<Integer> list) {
        if (root == null) return;
        inorder(root.left, target, k, list);

        if (list.size() < k) list.addLast(root.val);
        else {
            if (target < list.getFirst()) return;
            if (Math.abs(root.val - target) > Math.abs(list.getFirst() - target)) return;
            list.removeFirst();
            list.addLast(root.val);
        }

        inorder(root.right, target, k, list);
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
        No272ClosestBinarySearchTreeValueII solution = new No272ClosestBinarySearchTreeValueII();
        List<Integer> list = solution.closestKValues2(root, 2.5D, 2);

        System.out.println("list = " + list);
    }
}