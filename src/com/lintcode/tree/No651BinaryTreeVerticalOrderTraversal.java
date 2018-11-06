package com.lintcode.tree;

import java.util.*;

public class No651BinaryTreeVerticalOrderTraversal {
    class LevelTreeNode {
        TreeNode node;
        int position;

        public LevelTreeNode(TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }

    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        final List<List<Integer>> R = new LinkedList<>();
        if (root == null) return R;

        final Queue<LevelTreeNode> q = new LinkedList<>();
        final Map<Integer, List<Integer>> map = new HashMap<>();
        q.offer(new LevelTreeNode(root, 0));
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            LevelTreeNode levelNode = q.poll();
            TreeNode node = levelNode.node;
            int position = levelNode.position;
            min = Math.min(min, position);
            max = Math.max(max, position);

            map.putIfAbsent(position, new LinkedList<>());
            map.get(position).add(node.val);

            if (node.left != null) q.offer(new LevelTreeNode(node.left, position - 1));
            if (node.right != null) q.offer(new LevelTreeNode(node.right, position + 1));
        }

        for (int i = min; i <= max; i++) R.add(map.get(i));
        return R;
    }
}
