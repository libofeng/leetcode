package com.leetcode.tree.nary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class No431EncodeNaryTreeToBinaryTreeRecursion {

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) return null;
        return encode(Arrays.asList(root));
    }

    private TreeNode encode(List<Node> list) {
        if (list == null || list.isEmpty()) return null;
        Iterator<Node> iterator = list.iterator();

        Node next = iterator.next();
        TreeNode root = new TreeNode(next.val);
        root.left = encode(next.children);

        TreeNode current = root;
        while (iterator.hasNext()) {
            next = iterator.next();
            current.right = encode(next);

            current = current.right;
        }

        return root;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) return null;

        Node node = new Node(root.val, new ArrayList<>());
        decode(node, root.left);

        return node;
    }

    private void decode(Node parent, TreeNode root) {
        if (root == null) return;

        parent.children.add(decode(root));
        decode(parent, root.right);
    }
}
