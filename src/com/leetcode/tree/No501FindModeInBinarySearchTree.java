package com.leetcode.tree;

public class No501FindModeInBinarySearchTree {
    private TreeNode prev;
    private int maxCount, count, len, index;
    private int[] result;

    public int[] findMode(TreeNode root) {
        count(root);
        if (count > 0 && count == maxCount) len++;
        else if (count > maxCount) {
            maxCount = count;
            len = 1;
        }
        count = 0;

        result = new int[len];

        inorder(root);
        if (index < len && count == maxCount) result[index++] = prev.val;
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);

        if (prev != null && root.val != prev.val) {
            if (count == maxCount) result[index++] = prev.val;
            count = 0;
        }
        prev = root;
        count++;

        inorder(root.right);
    }

    private void count(TreeNode root) {
        if (root == null) return;
        count(root.left);

        if (prev != null && root.val != prev.val) {
            if (count > maxCount) {
                maxCount = count;
                len = 1;
            } else if (count == maxCount) len++;

            count = 0;
        }

        prev = root;
        count++;

        count(root.right);
    }
}
