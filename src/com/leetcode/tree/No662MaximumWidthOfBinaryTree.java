package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class No662MaximumWidthOfBinaryTree {
    class IdxNode {
        TreeNode node;
        int idx;

        IdxNode(TreeNode n, int i) {
            node = n;
            idx = i;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<IdxNode> q = new LinkedList<>();
        if (root != null) q.offer(new IdxNode(root, 1));

        while (!q.isEmpty()) {
            int size = q.size();
            IdxNode first = null, last = null;
            while (size-- > 0) {
                IdxNode n = q.poll();
                if (first == null) first = n;
                last = n;

                if (n.node.left != null) q.offer(new IdxNode(n.node.left, n.idx * 2));
                if (n.node.right != null) q.offer(new IdxNode(n.node.right, n.idx * 2 + 1));
            }
            max = Math.max(max, last.idx - first.idx + 1);
        }

        return max;
    }
}
