package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class No113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        final List<List<Integer>> result = new ArrayList<>();
        preorder(root, result, new ArrayList<>(), sum);
        return result;
    }

    private void preorder(TreeNode root, List<List<Integer>> result, List<Integer> path, int sum) {
        if (root == null) return;

        path.add(root.val);
        sum -= root.val;

        if (root.left == null && root.right == null) {
            if (sum == 0) {
                result.add(new ArrayList<>(path));
            }

            path.remove(path.size() - 1);
            return;
        }

        preorder(root.left, result, path, sum);
        preorder(root.right, result, path, sum);

        path.remove(path.size() - 1);
    }
}
