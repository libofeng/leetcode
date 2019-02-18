package com.leetcode.tree;


import java.util.*;

public class No314BinaryTreeVerticalOrderTraversal {
    class ColumnNode {
        TreeNode node;
        int col;

        public ColumnNode(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        final List<List<Integer>> R = new LinkedList<>();
        if (root == null) return R;

        final Queue<ColumnNode> q = new LinkedList<>();
        final Map<Integer, List<Integer>> map = new TreeMap<>();
        q.offer(new ColumnNode(root, 0));

        while (!q.isEmpty()) {
            ColumnNode levelNode = q.poll();
            TreeNode node = levelNode.node;
            int col = levelNode.col;

            map.putIfAbsent(col, new LinkedList<>());
            map.get(col).add(node.val);

            if (node.left != null) q.offer(new ColumnNode(node.left, col - 1));
            if (node.right != null) q.offer(new ColumnNode(node.right, col + 1));
        }

        R.addAll(map.values());
        return R;
    }
}
