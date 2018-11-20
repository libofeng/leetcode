package com.lintcode.array;

public class SegmentTreeSum {
    class Node {
        int start, end, sum;
        Node left, right;

        Node(int l, int r, int val) {
            start = l;
            end = r;
            sum = val;
        }
    }

    private Node root;

    public SegmentTreeSum(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }

    private Node build(int[] nums, int start, int end) {
        if (end < start) return null;
        if (start == end) return new Node(start, end, nums[start]);

        int mid = start + (end - start) / 2;

        Node node = new Node(start, end, 0);
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
        return find(root, i, j);
    }

    private int find(Node node, int i, int j) {
        if (i <= node.start && j >= node.end) return node.sum;

        int mid = node.start + (node.end - node.start) / 2;
        if (i > mid) return find(node.right, i, j);
        else if (j <= mid) return find(node.left, i, j);

        return find(node.left, i, mid) + find(node.right, mid + 1, j);
    }
}
