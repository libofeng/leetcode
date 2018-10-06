package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class No100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Queue
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            final TreeNode n1 = queue.poll(), n2 = queue.poll();

            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.val != n2.val) return false;

            queue.offer(n1.left);
            queue.offer(n2.left);
            queue.offer(n1.right);
            queue.offer(n2.right);
        }

        return true;
    }


    public boolean isSameTree3(TreeNode p, TreeNode q) {
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()) {
            final TreeNode n1 = stack.pop(), n2 = stack.pop();

            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.val != n2.val) return false;

            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
            stack.push(n1.left);
        }

        return true;
    }
}
