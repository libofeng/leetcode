package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class No95UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {
        final List<TreeNode> R = new ArrayList<>();
        if (start > end) {
            R.add(null);
            return R;
        }

        for (int i = start; i <= end; i++) {
            final List<TreeNode> left = build(start, i - 1), right = build(i + 1, end);
            for (TreeNode leftRoot : left) {
                for (TreeNode rightRoot : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftRoot;
                    node.right = rightRoot;
                    R.add(node);
                }
            }
        }

        return R;
    }
}
