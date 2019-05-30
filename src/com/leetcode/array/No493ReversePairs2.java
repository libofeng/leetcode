package com.leetcode.array;

import java.util.Arrays;

public class No493ReversePairs2 {
    public int reversePairs(int[] nums) {
        Node root = null;
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int n = nums[i];
            count += search(root, n, 0);
            root = insert(root, 2L * n);
        }

        return count;
    }

    private int search(Node root, int n, int smallCount) {
        if (root == null) return smallCount;
        if (root.val == n) return root.smallCount + smallCount;
        if (n < root.val) return search(root.left, n, smallCount);
        else return search(root.right, n, smallCount + root.count + root.smallCount);
    }

    private Node insert(Node root, long n) {
        if (root == null) root = new Node(n);
        else if (root.val == n) root.count++;
        else if (n < root.val) {
            root.smallCount++;
            root.left = insert(root.left, n);
        } else {
            root.right = insert(root.right, n);
        }

        return root;
    }

    // https://leetcode.com/problems/reverse-pairs/discuss/97268/General-principles-behind-problems-similar-to-%22Reverse-Pairs%22
    class Node {
        Node left, right;
        long val;
        int count, smallCount;

        Node(long v) {
            count = 1;
            val = v;
        }
    }
}
