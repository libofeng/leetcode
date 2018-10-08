package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class No113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        final List<List<Integer>> R = new ArrayList<>();
        helper(root, sum, R, new ArrayList<>());

        return R;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> R, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> r = new ArrayList<>(list);
            r.add(root.val);
            R.add(r);
            return;
        }

        list.add(root.val);
        helper(root.left, sum - root.val, R, list);
        helper(root.right, sum - root.val, R, list);
        list.remove(list.size() - 1);
    }
}
