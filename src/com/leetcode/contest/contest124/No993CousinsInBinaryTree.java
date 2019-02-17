package com.leetcode.contest.contest124;

public class No993CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode lca = lca(root, x, y);
        return depth(root, x, 0) == depth(root, y, 0) && lca.left.val !=x && lca.left.val != y;
    }

    private int depth(TreeNode root, int x, int d){
        if(root == null) return -1;
        if(root.val == x) return d;

        int left = depth(root.left, x, d+1), right = depth(root.right, x, d+1);
        if(left==-1 && right == -1) return -1;
        return left==-1? right : left;
    }

    private TreeNode lca(TreeNode root, int x, int y){
        if(root == null) return null;
        if(x == root.val || y == root.val) return root;
        TreeNode left = lca(root.left, x, y), right = lca(root.right, x, y);
        if(left!=null && right !=null) return root;
        return left==null? right : left;
    }
}
