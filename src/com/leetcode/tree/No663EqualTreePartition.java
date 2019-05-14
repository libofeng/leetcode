package com.leetcode.tree;

import java.util.HashSet;
import java.util.Set;

public class No663EqualTreePartition {
    private Set<Integer> sums = new HashSet<>();

    public boolean checkEqualTree(TreeNode root) {
        if (root == null) return false;
        int left = sum(root.left), right = sum(root.right), sum = left + right + root.val;
        if (sum % 2 != 0) return false;

        return sums.contains(sum / 2);
    }

    private int sum(TreeNode root) {
        if (root == null) return 0;

        int s = sum(root.left) + sum(root.right) + root.val;
        sums.add(s);

        return s;
    }
}
