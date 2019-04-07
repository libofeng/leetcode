package com.leetcode.contest.contest131;

public class No5017SumOfRootToLeafBinaryNumbers {
    int sum = 0;
    private static final int MOD = 1000000007;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int pathSum) {
        if (root == null) return;

        pathSum = (2 * pathSum + root.val) % MOD;
        if (root.left == null && root.right == null) {
            sum = (sum + pathSum) % MOD;
            return;
        }

        dfs(root.left, pathSum);
        dfs(root.right, pathSum);
    }
}
