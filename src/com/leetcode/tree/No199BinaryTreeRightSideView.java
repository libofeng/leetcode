package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        final List<Integer> R = new LinkedList<>();
        final Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);

        while (!q.isEmpty()) {
            final int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if (i == len - 1) R.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }

        return R;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        final List<Integer> R = new LinkedList<>();
        LinkedList<TreeNode> level = new LinkedList<>();
        if (root != null) level.add(root);

        while (!level.isEmpty()) {
            final LinkedList<TreeNode> temp = new LinkedList<>();
            for (TreeNode node : level) {
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            R.add(level.getLast().val);
            level = temp;
        }

        return R;
    }

    // ---------------------------

    int maxDepth = -1;

    public List<Integer> rightSideView3(TreeNode root) {
        List<Integer> view = new LinkedList<>();
        preorder(root, view, 0);
        return view;
    }

    private void preorder(TreeNode root, List<Integer> view, int depth) {
        if (root == null) return;
        if (depth > maxDepth) {
            maxDepth = depth;
            view.add(root.val);
        }

        preorder(root.right, view, depth + 1);
        preorder(root.left, view, depth + 1);
    }
}
