package com.leetcode.tree;

public class No117PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0), prev = dummy;
        while (root != null) {
            if (root.left != null) {
                prev.next = root.left;
                prev = prev.next;
            }

            if (root.right != null) {
                prev.next = root.right;
                prev = prev.next;
            }

            if (root.next == null) {
                root = dummy.next;
                dummy.next = null;
                prev = dummy;
            } else root = root.next;
        }
    }
}
