package com.leetcode.contest.contest150;

import java.util.ArrayList;
import java.util.List;

public class No5052MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        final List<Integer> sums = new ArrayList<>();
        dfs(root, sums, 0);

        int maxSum = Integer.MIN_VALUE, level = 0;
        for (int i = 0; i < sums.size(); i++) {
            if (sums.get(i) > maxSum) {
                maxSum = sums.get(i);
                level = i + 1;
            }
        }
        return level;
    }

    private void dfs(TreeNode root, List<Integer> sums, int d) {
        if (root == null) return;
        if (d == sums.size()) sums.add(0);

        sums.set(d, sums.get(d) + root.val);

        dfs(root.left, sums, d + 1);
        dfs(root.right, sums, d + 1);
    }
}
