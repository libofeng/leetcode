package com.leetcode.tree;


import java.util.*;

public class No314BinaryTreeVerticalOrderTraversal {
    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        final Queue<ColumnNode> q = new LinkedList<>();
        final Map<Integer, List<Integer>> map = new TreeMap<>();
        q.offer(new ColumnNode(root, 0));

        while (!q.isEmpty()) {
            ColumnNode levelNode = q.poll();
            TreeNode node = levelNode.node;
            int col = levelNode.col;

            map.computeIfAbsent(col, k -> new ArrayList<>()).add(node.val);

            if (node.left != null) q.offer(new ColumnNode(node.left, col - 1));
            if (node.right != null) q.offer(new ColumnNode(node.right, col + 1));
        }

        return new ArrayList<>(map.values());
    }

    // DFS, but this solution NOT pass the test-case, since the elements in every level may not match.
    public List<List<Integer>> verticalOrder2(TreeNode root) {
        final Map<Integer, List<Integer>> map = new TreeMap<>();
        dfs(root, map, 0);

        return new ArrayList<>(map.values());
    }

    private void dfs(TreeNode root, Map<Integer, List<Integer>> map, int col) {
        if (root == null) return;

        map.computeIfAbsent(col, k -> new ArrayList<>()).add(root.val);
        dfs(root.left, map, col - 1);
        dfs(root.right, map, col + 1);
    }

    //Without using the lambda, this implementation has better performance.
    public List<List<Integer>> verticalOrder3(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        final Queue<ColumnNode> q = new LinkedList<>();
        final Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0, max = 0;

        q.offer(new ColumnNode(root, 0));
        while (!q.isEmpty()) {
            TreeNode node = q.peek().node;
            int col = q.poll().col;

            min = Math.min(min, col);
            max = Math.max(max, col);
            if (!map.containsKey(col)) map.put(col, new ArrayList<>());
            map.get(col).add(node.val);

            if (node.left != null) q.offer(new ColumnNode(node.left, col - 1));
            if (node.right != null) q.offer(new ColumnNode(node.right, col + 1));
        }

        for (int i = min; i <= max; i++) result.add(map.get(i));
        return result;
    }
}
