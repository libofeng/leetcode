package com.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class No106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private int p = 0;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

        p = postorder.length - 1;
        return build(inorder, 0, inorder.length - 1, postorder);
    }

    private TreeNode build(int[] inorder, int start, int end, int[] postorder) {
        if (end < start) return null;
        int n = postorder[p--];
        if (start == end) return new TreeNode(n);

        int i = map.get(n);
        TreeNode node = new TreeNode(n);
        node.right = build(inorder, i + 1, end, postorder);
        node.left = build(inorder, start, i - 1, postorder);

        return node;
    }
}
