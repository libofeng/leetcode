package com.lintcode.tree;

public class No7SerializeAndDeserializeBinaryTree {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        return root == null ? "#" : root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        return buildTree(data.split(","));
    }

    private int index = 0;

    private TreeNode buildTree(String[] values) {
        String val = values[index++];
        if ("#".equals(val)) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(values);
        node.right = buildTree(values);
        return node;
    }
}
