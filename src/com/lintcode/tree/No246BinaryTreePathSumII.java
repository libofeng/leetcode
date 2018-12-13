package com.lintcode.tree;

import java.util.ArrayList;
import java.util.List;

public class No246BinaryTreePathSumII {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> R = new ArrayList<>();
        preorder(root, R, target, new ArrayList<>());

        return R;
    }

    private void preorder(TreeNode root, List<List<Integer>> R, int target, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);

        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == target) R.add(new ArrayList<>(path.subList(i, path.size())));
        }

        preorder(root.left, R, target, path);
        preorder(root.right, R, target, path);

        path.remove(path.size() - 1);
    }
}
