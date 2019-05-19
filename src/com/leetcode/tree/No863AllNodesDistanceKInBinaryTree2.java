package com.leetcode.tree;

import java.util.*;

public class No863AllNodesDistanceKInBinaryTree2 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        final Map<TreeNode, TreeNode> parents = new HashMap<>();
        mapToParents(root, null, parents);

        final Queue<TreeNode> q = new LinkedList<>();
        final Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);

        int d = 0;
        final List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (d == K) {
                    result.add(node.val);
                    continue;
                }

                if (parents.containsKey(node) && visited.add(parents.get(node))) q.offer(parents.get(node));
                if (node.left != null && visited.add(node.left)) q.offer(node.left);
                if (node.right != null && visited.add(node.right)) q.offer(node.right);
            }
            d++;
        }

        return result;
    }

    private void mapToParents(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parents) {
        if (root == null) return;
        if (parent != null) parents.put(root, parent);

        mapToParents(root.left, root, parents);
        mapToParents(root.right, root, parents);
    }
}
