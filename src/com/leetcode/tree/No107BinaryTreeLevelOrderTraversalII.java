package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No107BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        final LinkedList<List<Integer>> R = new LinkedList<>();
        List<TreeNode> level = new LinkedList<>();
        if (root != null) level.add(root);

        while (!level.isEmpty()) {
            final List<Integer> r = new LinkedList<>();
            final List<TreeNode> temp = new LinkedList<>();
            for (TreeNode node : level) {
                r.add(node.val);
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }

            R.addFirst(r);
            level = temp;
        }

        return R;
    }


    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        final LinkedList<List<Integer>> R = new LinkedList<>();
        final Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);

        while (!q.isEmpty()) {
            final List<Integer> r = new LinkedList<>();
            final int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                r.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            R.addFirst(r);
        }

        return R;
    }
}
