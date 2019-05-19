package com.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No863AllNodesDistanceKInBinaryTree {
    private Map<Integer, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        final List<Integer> result = new ArrayList<>();
        findTarget(root, target.val);
        findNodes(root, target.val, K, result);

        return result;
    }

    private void findNodes(TreeNode root, int target, int K, List<Integer> result) {
        if (root == null) return;
        else if (root.val == target) {
            collect(root, K, result);
            return;
        } else if (!map.containsKey(root.val)) return;
        else if (map.getOrDefault(root.val, -1) == K) {
            result.add(root.val);
            findNodes(root.left, target, K, result);
            findNodes(root.right, target, K, result);
            return;
        }

        System.out.println(root.val + "," + map.get(root.val));
        int d = K - map.get(root.val);
        if (root.left != null && map.containsKey(root.left.val)) {
            collect(root.right, d - 1, result);
            findNodes(root.left, target, K, result);
        } else if (root.right != null && map.containsKey(root.right.val)) {

            collect(root.left, d - 1, result);
            findNodes(root.right, target, K, result);
        }
    }

    private void collect(TreeNode root, int d, List<Integer> result) {
        if (root == null) return;
        if (d == 0) result.add(root.val);
        else {
            collect(root.left, d - 1, result);
            collect(root.right, d - 1, result);
        }
    }

    private int findTarget(TreeNode root, int target) {
        if (root == null) return -1;
        if (root.val == target) {
            map.put(root.val, 0);
            return 0;
        }

        int left = findTarget(root.left, target), right = findTarget(root.right, target);

        int d = -1;
        if (left >= 0) d = left + 1;
        else if (right >= 0) d = right + 1;

        if (d > 0) map.put(root.val, d);
        return d;
    }
}
