package com.leetcode.contest.contest144;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No1110DeleteNodesAndReturnForest2 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        final Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);

        for (int d : to_delete) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode t = q.poll();
                if (t.val != d) q.offer(t);
                dfs(q, t, d);
            }
        }

        return new ArrayList<>(q);
    }

    private TreeNode dfs(Queue<TreeNode> q, TreeNode root, int d) {
        if (root == null) return null;

        if (root.val == d) {
            if (root.left != null) q.offer(root.left);
            if (root.right != null) q.offer(root.right);
            root.left = null;
            root.right = null;

            return null;
        }

        root.left = dfs(q, root.left, d);
        root.right = dfs(q, root.right, d);
        return root;
    }
}
