package com.lintcode.tree;

import java.util.LinkedList;
import java.util.List;

public class No480BinaryTreePaths {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        final List<String> R = new LinkedList<>();
        helper(root, R, "");
        return R;
    }

    private void helper(TreeNode root, List<String> R, String path) {
        if (root == null) return;

        path += path.isEmpty() ? root.val : ("->" + root.val);
        if (root.left == null && root.right == null) {
            R.add(path);
            return;
        }

        helper(root.left, R, path);
        helper(root.right, R, path);

    }
}
