package com.leetcode.tree;

public class No968BinaryTreeCameras {
    private static final int NO_COVERED = 0, CAMERA_COVERED = 1, HAS_CAMERA = 2;
    private int cameras = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) == NO_COVERED ? 1 : 0) + cameras;
    }

    private int dfs(TreeNode root) {
        if (root == null) return CAMERA_COVERED;
        if (root.left == null && root.right == null) return NO_COVERED;

        int left = dfs(root.left), right = dfs(root.right);
        if (left == NO_COVERED || right == NO_COVERED) {
            cameras++;
            return HAS_CAMERA;
        }

        return left == HAS_CAMERA || right == HAS_CAMERA ? CAMERA_COVERED : NO_COVERED;
    }
}
