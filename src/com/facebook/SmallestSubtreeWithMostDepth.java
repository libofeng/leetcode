package com.facebook;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubtreeWithMostDepth {

    MutilTreeNode find(MutilTreeNode root) {
        return helper(root, maxDepth(root));
    }

    private MutilTreeNode helper(MutilTreeNode root, int depth) {
        if (root == null || root.children.isEmpty()) return root;

        int count = 0;
        MutilTreeNode next = null;
        for (MutilTreeNode N : root.children) {
            if (depthMap.get(N) == depth - 1) {
                count++;
                next = N;
            }
        }
        return count > 1 ? root : helper(next, depth - 1);
    }

    Map<MutilTreeNode, Integer> depthMap = new HashMap<>();

    private int maxDepth(MutilTreeNode root) {
        if (root == null) return 0;

        int max = 0;
        for (MutilTreeNode N : root.children) max = Math.max(max, maxDepth(N));

        depthMap.put(root, max + 1);
        return max + 1;
    }

    public static void main(String[] args) {
        MutilTreeNode root = new MutilTreeNode(5);
        MutilTreeNode child1 = new MutilTreeNode(3);
        MutilTreeNode child2 = new MutilTreeNode(4);
        MutilTreeNode child3 = new MutilTreeNode(6);
        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        MutilTreeNode child11 = new MutilTreeNode(2);
        child11.children.add(new MutilTreeNode(10));
        child1.children.add(child11);

        MutilTreeNode child21 = new MutilTreeNode(1);
        MutilTreeNode child211 = new MutilTreeNode(11);
        child21.children.add(child211);
        MutilTreeNode child212 = new MutilTreeNode(21);
        child211.children.add(child212);
        MutilTreeNode child213 = new MutilTreeNode(31);
        child212.children.add(child213);
        child1.children.add(child21);

        child3.children.add(new MutilTreeNode(8));
        child3.children.add(new MutilTreeNode(9));

        SmallestSubtreeWithMostDepth solution = new SmallestSubtreeWithMostDepth();
        MutilTreeNode subRoot = solution.find(root);

        System.out.println("subRoot.val = " + subRoot.val);

        solution = new SmallestSubtreeWithMostDepth();
        subRoot = solution.find(null);
        System.out.println("subRoot = " + subRoot);

        solution = new SmallestSubtreeWithMostDepth();
        subRoot = solution.find(new MutilTreeNode(1));
        System.out.println("subRoot.val = " + subRoot.val);

    }
}
