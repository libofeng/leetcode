package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class No437PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        return samePathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int samePathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return (root.val == sum ? 1 : 0) + samePathSum(root.left, sum - root.val) + samePathSum(root.right, sum - root.val);
    }

    // -------------------------------

    private int count = 0;

    public int pathSum2(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<>());

        return count;
    }

    private void dfs(TreeNode root, int sum, List<TreeNode> path) {
        if (root == null) return;

        path.add(root);

        int pathSum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            pathSum += path.get(i).val;
            if (pathSum == sum) count++;
        }
        dfs(root.left, sum, path);
        dfs(root.right, sum, path);

        path.remove(path.size() - 1);
    }
}
