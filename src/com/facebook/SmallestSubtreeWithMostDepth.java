package com.facebook;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubtreeWithMostDepth {

    MultipleTreeNode find(MultipleTreeNode root) {
        return helper(root, maxDepth(root));
    }

    private MultipleTreeNode helper(MultipleTreeNode root, int depth) {
        if (root == null || root.children.isEmpty()) return root;

        int count = 0;
        MultipleTreeNode next = null;
        for (MultipleTreeNode N : root.children) {
            if (depthMap.get(N) == depth - 1) {
                count++;
                next = N;
            }
        }
        return count > 1 ? root : helper(next, depth - 1);
    }

    Map<MultipleTreeNode, Integer> depthMap = new HashMap<>();

    private int maxDepth(MultipleTreeNode root) {
        if (root == null) return 0;

        int max = 0;
        for (MultipleTreeNode N : root.children) max = Math.max(max, maxDepth(N));

        depthMap.put(root, max + 1);
        return max + 1;
    }

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

        SmallestSubtreeWithMostDepth solution = new SmallestSubtreeWithMostDepth();
        MultipleTreeNode subRoot = solution.find(root);

        System.out.println("subRoot.val = " + subRoot.val);

        solution = new SmallestSubtreeWithMostDepth();
        subRoot = solution.find(null);
        System.out.println("subRoot = " + subRoot);

        solution = new SmallestSubtreeWithMostDepth();
        subRoot = solution.find(new MultipleTreeNode(1));
        System.out.println("subRoot.val = " + subRoot.val);

    }
}
