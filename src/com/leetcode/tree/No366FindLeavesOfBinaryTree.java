package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class No366FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();

        height(root, result);
        return result;
    }

    private int height(TreeNode root, List<List<Integer>> result) {
        if (root == null) return 0;

        int h = Math.max(height(root.left, result), height(root.right, result));
        if (result.size() == h) result.add(new ArrayList<>());
        result.get(h).add(root.val);

        return h + 1;
    }
}
