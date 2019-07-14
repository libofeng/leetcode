package com.leetcode.contest.contest145;


public class No1123LowestCommonAncestorOfDeepestLeavesUser {
    // See: 865
    private TreeNode lca;
    private int maxDepth;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);

        return lca;
    }

    private int dfs(TreeNode root, int d){
        if(root == null){
            maxDepth = Math.max(maxDepth, d);
            return d;
        }

        int left = dfs(root.left, d + 1), right = dfs(root.right, d + 1);
        if(left == right && left == maxDepth) lca = root;

        return Math.max(left, right);
    }
}
