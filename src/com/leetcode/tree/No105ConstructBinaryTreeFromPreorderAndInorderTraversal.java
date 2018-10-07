package com.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class No105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int p = 0;
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int start, int end) {
        if (end < start) return null;
        int n = preorder[p++];
        if (start == end) return new TreeNode(n);

        int i = map.get(n);
        TreeNode node = new TreeNode(n);
        node.left = build(preorder, inorder, start, i - 1);
        node.right = build(preorder, inorder, i + 1, end);

        return node;
    }
}
