package com.leetcode.tree.nary;

import java.util.ArrayList;
import java.util.Iterator;

public class No431EncodeNaryTreeToBinaryTree {
    // solution: Left subtree: its children; Right subtree: its sibling

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) return null;

        TreeNode node = new TreeNode(root.val);

        Iterator<Node> iterator = root.children.iterator();
        if (iterator.hasNext()) {
            node.left = encode(iterator.next());
        }

        TreeNode current = node.left;
        while (iterator.hasNext()) {
            current.right = encode(iterator.next());
            current = current.right;
        }

        return node;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) return null;

        Node node = new Node(root.val, new ArrayList<>());

        TreeNode current = root.left;
        while (current != null) {
            node.children.add(decode(current));
            current = current.right;
        }

        return node;
    }
}
