package com.lintcode.tree;

public class No1181DiameterOfBinaryTree {
    /**
     * @param root: a root of binary tree
     * @return: return a integer
     */
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    private int maxDepth(TreeNode root){
        if(root == null) return 0;

        int left = maxDepth(root.left), right = maxDepth(root.right);
        diameter = Math.max(diameter,  left + right);

        return Math.max(left, right) + 1;
    }
}
