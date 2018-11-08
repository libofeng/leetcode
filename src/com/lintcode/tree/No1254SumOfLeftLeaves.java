package com.lintcode.tree;

public class No1254SumOfLeftLeaves {
    /**
     * @param root: t
     * @return: the sum of all left leaves
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) sum += root.left.val;
            else sum += sumOfLeftLeaves(root.left);
        }

        if (root.right != null) sum += sumOfLeftLeaves(root.right);
        return sum;
    }


    public int sumOfLeftLeaves2(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && isLeft) return root.val;

        int sum = 0;
        sum += helper(root.left, true);
        sum += helper(root.right, false);

        return sum;
    }
}
