package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class No971FlipBinaryTreeToMatchPreorderTraversal {
    private int p = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list = new ArrayList<>();
        return helper(root, voyage, list) && p == voyage.length ? list : Collections.singletonList(-1);
    }


    private boolean helper(TreeNode root, int[] voyage, List<Integer> list) {
        if (root == null) return true;

        if (p >= voyage.length || voyage[p++] != root.val) return false;
        if (root.left != null && root.right != null && p < voyage.length && root.left.val != voyage[p]) {
            list.add(root.val);
            return helper(root.right, voyage, list) && helper(root.left, voyage, list);
        }

        return helper(root.left, voyage, list) && helper(root.right, voyage, list);
    }


    public List<Integer> flipMatchVoyage2(TreeNode root, int[] voyage) {
        final List<Integer> list = new ArrayList<>(), failed = Collections.singletonList(-1);

        final Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);

        int index = 0;
        while (index < voyage.length && !stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (voyage[index++] != node.val) return failed;

            if (node.left != null && node.right != null && index < voyage.length && voyage[index] != node.left.val) {
                list.add(node.val);
                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            } else {
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
        }

        return index == voyage.length && stack.isEmpty() ? list : failed;
    }
}
