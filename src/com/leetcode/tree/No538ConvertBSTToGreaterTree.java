package com.leetcode.tree;

public class No538ConvertBSTToGreaterTree {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.right);

        root.val += sum;
        sum = root.val;

        inorder(root.left);
    }
}
