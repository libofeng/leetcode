package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No515FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        final Queue<TreeNode> q = new LinkedList<>();

        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();

            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(max);
        }

        return result;
    }
}
