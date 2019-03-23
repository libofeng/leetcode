package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class No257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        final List<String> result = new ArrayList<>();
        preorder(root, result, "");
        return result;
    }

    private void preorder(TreeNode root, List<String> result, String path) {
        if (root == null) return;
        path += (path.isEmpty() ? "" : "->") + root.val;
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        preorder(root.left, result, path);
        preorder(root.right, result, path);
    }
}
