package com.lintcode.tree;

import java.util.ArrayList;
import java.util.List;

public class No472BinaryTreePathSumIII {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        List<List<Integer>> R = new ArrayList<>();
        preorder(root, R, target);
        return R;
    }

    private void preorder(ParentTreeNode root, List<List<Integer>> R, int target) {
        if (root == null) return;
        dfs(root, R, null, target, new ArrayList<>());
        preorder(root.left, R, target);
        preorder(root.right, R, target);
    }

    private void dfs(ParentTreeNode root, List<List<Integer>> R, ParentTreeNode prev, int target, List<Integer> path) {
        if (root == null) return;

        target -= root.val;
        path.add(root.val);

        if (target == 0) R.add(new ArrayList<>(path));

        if (prev != root.left) dfs(root.left, R, root, target, path);
        if (prev != root.right) dfs(root.right, R, root, target, path);
        if (prev != root.parent) dfs(root.parent, R, root, target, path);

        path.remove(path.size() - 1);
    }
}
