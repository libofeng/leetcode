package com.lintcode.tree;

public class No578LowestCommonAncestorIII {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        int count = visit(root, A, B);
        if(count<2) return null;

        return helper(root, A, B);
    }

    public TreeNode helper(TreeNode root, TreeNode A, TreeNode B) {
        if(root == null) return null;
        if(root.val == A.val || root.val == B.val) return root;

        TreeNode left = helper(root.left, A, B);
        TreeNode right = helper(root.right, A, B);

        if(left != null && right != null) return root;

        return left == null ? right : left;
    }

    private int visit(TreeNode root, TreeNode A, TreeNode B){
        if(root == null) return 0;

        int count = 0;
        if(root.val == A.val) count++;
        if(root.val == B.val) count++;

        count += visit(root.left, A, B);
        count += visit(root.right, A, B);
        return count;
    }
}
