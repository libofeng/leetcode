package com.leetcode.tree;

public class No222CountCompleteTreeNodes {
    // https://leetcode.com/problems/count-complete-tree-nodes/discuss/61958/Concise-Java-solutions-O(log(n)2)


    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left = root, right = root;
        int height = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null)
            return (1 << height) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodes2(TreeNode root) {
        int h = height(root);
        if (h < 0) return 0;

        return height(root.right) == h - 1 ? ((1 << h) + countNodes(root.right)) : ((1 << (h - 1)) + countNodes(root.left));
    }

    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    public int countNodes3(TreeNode root) {
        int nodes = 0, h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << h - 1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }
}
