package com.company.facebook;

public class SmallestSubtreeWithMostDepth2 {
    // By comparing to Binary tree, the condition for choosing LCA:
    // 1. depth == maxDepth, and the node is leaf
    // 2. the node child's max depth == maxDepth, and the max depth child number > 1

    MultipleTreeNode lca;
    int maxDepth;

    public static void main(String[] args) {
        MultipleTreeNode root = new MultipleTreeNode(5);
        MultipleTreeNode child1 = new MultipleTreeNode(3);
        MultipleTreeNode child2 = new MultipleTreeNode(4);
        MultipleTreeNode child3 = new MultipleTreeNode(6);
        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        MultipleTreeNode child11 = new MultipleTreeNode(2);
        child11.children.add(new MultipleTreeNode(10));
        child1.children.add(child11);

        MultipleTreeNode child21 = new MultipleTreeNode(1);
        MultipleTreeNode child211 = new MultipleTreeNode(11);
        child21.children.add(child211);
        MultipleTreeNode child212 = new MultipleTreeNode(21);
        child211.children.add(child212);
        MultipleTreeNode child213 = new MultipleTreeNode(31);
        child212.children.add(child213);
        child1.children.add(child21);

        child3.children.add(new MultipleTreeNode(8));
        child3.children.add(new MultipleTreeNode(9));

        SmallestSubtreeWithMostDepth2 solution = new SmallestSubtreeWithMostDepth2();
        MultipleTreeNode subRoot = solution.find(root); // expected: 31

        System.out.println("subRoot = " + (subRoot == null ? null : subRoot.val));

        solution = new SmallestSubtreeWithMostDepth2();
        subRoot = solution.find(null); // expected: null
        System.out.println("subRoot = " + subRoot);

        solution = new SmallestSubtreeWithMostDepth2();
        subRoot = solution.find(new MultipleTreeNode(1)); // expected: 1
        System.out.println("subRoot.val = " + (subRoot == null ? null : subRoot.val));

    }

    MultipleTreeNode find(MultipleTreeNode root) {
        if (root == null || root.children.isEmpty()) return root;

        maxDepth(root, 0);
        return lca;
    }

    private int maxDepth(MultipleTreeNode root, int d) {
        if (root.children.isEmpty()) {
            maxDepth = Math.max(maxDepth, d);
            if (d == maxDepth) lca = root;
            return d;
        }

        int max = d, count = 0;
        for (MultipleTreeNode N : root.children) {
            int childDepth = maxDepth(N, d + 1);
            if (childDepth > max) {
                count = 1;
                max = childDepth;
            } else if (childDepth == max) count++;
        }
        if (max == maxDepth && count > 1) lca = root;

        return max;
    }
}
