package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        final List<List<Integer>> R = new LinkedList<>();
        final Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.add(root);

        boolean fromLeft = true;
        while (!q.isEmpty()) {
            final int len = q.size();
            LinkedList<Integer> r = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                final TreeNode node = q.poll();

                if (fromLeft) {
                    r.add(node.val);
                } else {
                    r.addFirst(node.val);
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            R.add(r);
            fromLeft = !fromLeft;
        }

        return R;
    }
}
