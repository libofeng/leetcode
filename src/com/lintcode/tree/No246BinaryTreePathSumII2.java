package com.lintcode.tree;

import java.util.ArrayList;
import java.util.List;

public class No246BinaryTreePathSumII2 {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> R = new ArrayList<>();
        helper(root, R, target);

        return R;
    }

    private void helper(TreeNode root, List<List<Integer>> R, int target) {
        if (root == null) return;

        preorder(root, R, target, new ArrayList<>());

        helper(root.left, R, target);
        helper(root.right, R, target);
    }

    private void preorder(TreeNode root, List<List<Integer>> R, int target, List<Integer> path) {
        if (root == null) return;

        path.add(root.val);
        target -= root.val;
        if (target == 0) R.add(new ArrayList<>(path));

        preorder(root.left, R, target, path);
        preorder(root.right, R, target, path);

        path.remove(path.size() - 1);
    }
}
