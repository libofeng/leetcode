package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No637AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        final List<Double> result = new ArrayList<>();
        final Queue<TreeNode> q = new LinkedList<>();

        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size(), total = size;
            double sum = 0D;

            while (size-- > 0) {
                TreeNode node = q.poll();
                sum += node.val;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            result.add(sum / total);
        }

        return result;
    }
}
