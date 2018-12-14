package com.lintcode.tree;

public class No1353SumRootToLeafNumbers {
    /**
     * @param root: the root of the tree
     * @return: the total sum of all root-to-leaf numbers
     */
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return sum;
    }

    private void preorder(TreeNode root, int pathSum) {
        if (root == null) return;

        pathSum = pathSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += pathSum;
            return;
        }

        preorder(root.left, pathSum);
        preorder(root.right, pathSum);
    }
}
