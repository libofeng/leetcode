package com.leetcode.tree;

public class No297SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return root == null ? "#" : (root.val + "," + serialize(root.left) + "," + serialize(root.right));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        return build(data.split(","));
    }

    private int p = 0;

    private TreeNode build(String[] data) {
        String val = data[p++];
        if ("#".equals(val)) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = build(data);
        node.right = build(data);

        return node;
    }
}
