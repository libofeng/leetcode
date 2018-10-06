package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class No116PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        connect(root, null);
    }

    private void connect(TreeLinkNode node, TreeLinkNode next) {
        if (node == null) return;
        node.next = next;

        connect(node.left, node.right);
        if (next == null) connect(node.right, null);
        else connect(node.right, next.left);
    }

    public void connect2(TreeLinkNode root) {
        connect(root, null);
    }

    private void connect2(TreeLinkNode node, TreeLinkNode sibling) {
        if (node == null) return;
        if (sibling != null) sibling.next = node;

        if (node.left != null) connect2(node.left, sibling == null ? null : sibling.right);
        if (node.right != null) connect2(node.right, node.left);
    }

    public void connect3(TreeLinkNode root) {
        final Queue<TreeLinkNode> q = new LinkedList<>();
        if (root != null) q.offer(root);

        while (!q.isEmpty()) {
            final int len = q.size();
            TreeLinkNode prev = null;
            for (int i = 0; i < len; i++) {
                TreeLinkNode node = q.poll();
                if (prev != null) prev.next = node;
                prev = node;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
    }
}
