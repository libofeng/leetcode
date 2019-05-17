package com.leetcode.tree.nary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No429NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        final List<List<Integer>> result = new ArrayList<>();

        final Queue<Node> q = new LinkedList<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            final List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                Node node = q.poll();
                list.add(node.val);

                if (node.children != null) for (Node child : node.children) q.offer(child);
            }
            result.add(list);
        }

        return result;
    }
}
