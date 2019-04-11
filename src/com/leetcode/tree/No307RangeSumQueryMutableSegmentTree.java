package com.leetcode.tree;

public class No307RangeSumQueryMutableSegmentTree {
    class Node {
        int start, end, sum;
        Node left, right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private Node root;

    public No307RangeSumQueryMutableSegmentTree(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }

    private Node build(int[] nums, int start, int end) {
        if (end < start) return null;

        int mid = start + (end - start) / 2;
        Node node = new Node(start, end);
        if (start == end) {
            node.sum = nums[start];
            return node;
        }

        node.left = build(nums, start, mid);
        node.right = build(nums, mid + 1, end);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(Node node, int i, int val) {
        if (node.start == i && node.end == i) {
            node.sum = val;
            return;
        }

        int mid = node.start + (node.end - node.start) / 2;
        if (i <= mid) update(node.left, i, val);
        else update(node.right, i, val);

        node.sum = node.left.sum + node.right.sum;
    }

    public int sumRange(int i, int j) {
        if (i > j) return 0;
        return sumRange(root, i, j);
    }

    private int sumRange(Node node, int i, int j) {
        if (node.start == i && node.end == j) return node.sum;
        int mid = node.start + (node.end - node.start) / 2;
        if (j <= mid) return sumRange(node.left, i, j);
        else if (i > mid) return sumRange(node.right, i, j);
        return sumRange(node.left, i, mid) + sumRange(node.right, mid + 1, j);
    }
}
