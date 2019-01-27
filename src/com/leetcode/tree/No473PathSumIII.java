package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class No473PathSumIII {
    private int count = 0, sum = 0;

    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        preorder(root, new ArrayList<>());
        return count;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        int s = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            s += list.get(i);
            if (s == sum) count++;
        }

        preorder(root.left, list);
        preorder(root.right, list);

        list.remove(list.size() - 1);
    }
}
