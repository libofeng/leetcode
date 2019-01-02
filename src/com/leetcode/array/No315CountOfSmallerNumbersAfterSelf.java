package com.leetcode.array;

import java.util.Arrays;
import java.util.List;

public class No315CountOfSmallerNumbersAfterSelf {
    class Node {
        Node left, right;
        int val, totalCount, count;
        // count: total elements eq val
        // totalCount: total elements in the left subtree(including duplication)

        Node(int v) {
            val = v;
            count = 1;
        }
    }


    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];

        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) root = insert(root, nums[i], result, i, 0);
        return Arrays.asList(result);
    }

    private Node insert(Node node, int val, Integer[] result, int i, int preTotal) {
        if (node == null) {
            node = new Node(val);
            result[i] = preTotal;
        } else if (node.val == val) {
            node.count++;
            result[i] = preTotal + node.totalCount;
        } else if (node.val > val) {
            node.totalCount++;
            node.left = insert(node.left, val, result, i, preTotal);
        } else {
            node.right = insert(node.right, val, result, i, preTotal + node.count + node.totalCount);
        }
        return node;
    }


    public static void main(String[] args) {
        No315CountOfSmallerNumbersAfterSelf solution = new No315CountOfSmallerNumbersAfterSelf();
        List<Integer> result = solution.countSmaller(new int[]{5, 2, 6, 1});
        System.out.println("result = " + result);
    }
}
