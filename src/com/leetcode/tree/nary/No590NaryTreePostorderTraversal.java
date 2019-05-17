package com.leetcode.tree.nary;

import java.util.ArrayList;
import java.util.List;

public class No590NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        final List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(Node root, List<Integer> result) {
        if (root == null) return;

        if (root.children != null) for (Node child : root.children) postorder(child, result);
        result.add(root.val);
    }
}
