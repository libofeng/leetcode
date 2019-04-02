package com.leetcode.tree;

public class No449SerializeAndDeserializeBST {

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

    private TreeNode build(String[] tokens) {
        if (p > tokens.length) return null;

        String val = tokens[p++];
        if ("#".equals(val)) return null;

        final TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = build(tokens);
        root.right = build(tokens);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
