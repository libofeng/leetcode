package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        final ArrayList<List<Integer>> R = new ArrayList<>();
        helper(root, R, 0);

        return R;
    }

    private void helper(TreeNode node, ArrayList<List<Integer>> R, int level) {
        if (node == null) return;

        if (R.size() == level) R.add(new ArrayList<>());
        List<Integer> list = R.get(level);

        list.add(node.val);
        helper(node.left, R, level + 1);
        helper(node.right, R, level + 1);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        final List<List<Integer>> R = new LinkedList<>();
        List<TreeNode> collector = new LinkedList<>();
        if (root != null) collector.add(root);

        while (!collector.isEmpty()) {
            final List<Integer> r = new LinkedList<>();
            final List<TreeNode> temp = new LinkedList<>();
            for (TreeNode node : collector) {
                r.add(node.val);
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }

            R.add(r);
            collector = temp;
        }

        return R;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        final List<List<Integer>> R = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);

        while (!q.isEmpty()) {
            final List<Integer> r = new LinkedList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                r.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            R.add(r);
        }

        return R;
    }
}
