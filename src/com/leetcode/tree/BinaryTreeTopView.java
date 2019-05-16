package com.leetcode.tree;

import java.util.*;

public class BinaryTreeTopView {
    public static void main(String[] args) {
        /* Create following Binary Tree
         1
        / \
        2 3
        \
          4
            \
              5
                \
                 6
           */
        BinaryTreeTopView tree = new BinaryTreeTopView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        System.out.println("Following are nodes in top view of Binary Tree");
        List<Integer> view = tree.topView(root);

        System.out.println("view = " + view);
    }

    List<Integer> topView(TreeNode root) {
        final Map<Integer, Integer> view = new TreeMap<>();
        final Queue<ColumnNode> q = new LinkedList<>();

        if (root != null) q.offer(new ColumnNode(0, root));
        while (!q.isEmpty()) {
            ColumnNode n = q.poll();
            TreeNode node = n.node;
            int col = n.col;

            view.putIfAbsent(col, node.val);
            // view.put(col, node.val); // bottom view

            if (node.left != null) q.offer(new ColumnNode(col - 1, node.left));
            if (node.right != null) q.offer(new ColumnNode(col + 1, node.right));
        }

        return new ArrayList<>(view.values());
    }

    class ColumnNode {
        TreeNode node;
        int col;

        ColumnNode(int col, TreeNode node) {
            this.col = col;
            this.node = node;
        }
    }
}
