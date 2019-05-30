package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No662MaximumWidthOfBinaryTree {
    class IdxNode {
        TreeNode node;
        int idx;

        IdxNode(TreeNode n, int i) {
            node = n;
            idx = i;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<IdxNode> q = new LinkedList<>();
        if (root != null) q.offer(new IdxNode(root, 1));

        while (!q.isEmpty()) {
            int size = q.size();
            IdxNode first = null, last = null;
            while (size-- > 0) {
                IdxNode n = q.poll();
                if (first == null) first = n;
                last = n;

                if (n.node.left != null) q.offer(new IdxNode(n.node.left, n.idx * 2));
                if (n.node.right != null) q.offer(new IdxNode(n.node.right, n.idx * 2 + 1));
            }
            max = Math.max(max, last.idx - first.idx + 1);
        }

        return max;
    }

    public int widthOfBinaryTree2(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }

    private int dfs(TreeNode root, int level, int id, List<Integer> start, List<Integer> end) {
        if (root == null) return 0;
        if (level == start.size()) {
            start.add(id);
            end.add(id);
        } else end.set(level, id);

        int current = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, id * 2, start, end);
        int right = dfs(root.right, level + 1, id * 2 + 1, start, end);

        return Math.max(current, Math.max(left, right));
    }
}
