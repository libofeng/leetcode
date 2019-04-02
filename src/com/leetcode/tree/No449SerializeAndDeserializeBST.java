package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class No449SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        final Stack<TreeNode> stack = new Stack<>();
        if (root == null) return "#";

        stack.push(root);

        final StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sb.append(node.val).append(",");

            // the order here is important
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "#".equals(data)) return null;
        final Queue<Integer> q = new LinkedList<>();
        for (String t : data.split(",")) q.offer(Integer.parseInt(t));

        return build(q);
    }

    private TreeNode build(Queue<Integer> q) {
        if (q.isEmpty()) return null;


        TreeNode root = new TreeNode(q.poll());
        final Queue<Integer> left = new LinkedList<>();
        while (!q.isEmpty() && q.peek() < root.val) left.offer(q.poll());

        root.left = build(left);
        root.right = build(q);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
