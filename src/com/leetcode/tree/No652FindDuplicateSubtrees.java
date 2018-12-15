package com.leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class No652FindDuplicateSubtrees {
    final Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> R = new LinkedList<>();
        serialize(root, R);

        return R;
    }

    private String serialize(TreeNode root, List<TreeNode> R) {
        if (root == null) return "#";

        String serialization = root.val + "," + serialize(root.left, R) + "," + serialize(root.right, R);
        map.put(serialization, map.getOrDefault(serialization, 0) + 1);
        if (map.get(serialization) == 2) R.add(root);

        return serialization;
    }
}
