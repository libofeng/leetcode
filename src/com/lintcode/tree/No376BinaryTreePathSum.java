package com.lintcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No376BinaryTreePathSum {

    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        final List<List<Integer>> R = new ArrayList<>();
        preorder(root, R, target, new LinkedList<>());
        return R;
    }

    private void preorder(TreeNode root, List<List<Integer>> R, int target, LinkedList<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == root.val) R.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        preorder(root.left, R, target - root.val, path);
        preorder(root.right, R, target - root.val, path);

        path.removeLast();
    }
}
