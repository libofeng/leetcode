package com.leetcode.tree.nary;

import java.util.ArrayList;
import java.util.List;

public class No589NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        final List<Integer> result = new ArrayList<>();

        preorder(root, result);
        return result;
    }

    private void preorder(Node root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        if (root.children != null) for (Node child : root.children) preorder(child, result);
    }
}
