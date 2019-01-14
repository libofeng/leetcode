package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // BIT

    public List<Integer> countSmaller3(int[] nums) {
        final int n = nums.length;
        final Integer[] result = new Integer[nums.length];
        if (nums.length == 0) return Arrays.asList(result);

        int[] copy = nums.clone();
        Arrays.sort(copy);

        final int[] BIT = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int index = findIndex(copy, nums[i]);
            result[i] = query(BIT, index);
            update(BIT, index);
        }

        return Arrays.asList(result);
    }

    public List<Integer> countSmaller4(int[] nums) {
        final Integer[] result = new Integer[nums.length];
        final int[] BIT = new int[nums.length + 1];
        final Map<Integer, Integer> map = new HashMap<>();

        final int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = sorted.length - 1; i >= 0; i--) map.put(sorted[i], i);

        for (int i = nums.length - 1; i >= 0; i--) {
            int idx = map.get(nums[i]);
            result[i] = query(BIT, idx);
            update(BIT, idx);
        }

        return Arrays.asList(result);
    }

    private int findIndex(int[] nums, int num) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (num <= nums[mid]) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    private void update(int[] BIT, int index) {
        for (int i = index + 1; i < BIT.length; i += (i & -i)) BIT[i] += 1;
    }

    private int query(int[] BIT, int index) {
        int count = 0;
        for (int i = index; i > 0; i -= (i & -i)) count += BIT[i];

        return count;
    }


    public static void main(String[] args) {
        No315CountOfSmallerNumbersAfterSelf solution = new No315CountOfSmallerNumbersAfterSelf();
        List<Integer> result = solution.countSmaller(new int[]{5, 2, 6, 1});
        System.out.println("result = " + result);
    }
}
