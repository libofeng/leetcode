package com.leetcode.tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class No654MaximumBinaryTree {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);

        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;

        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) max = Math.max(max, nums[i]);

        final TreeNode root = new TreeNode(max);
        int index = map.get(max);
        root.left = build(nums, start, index - 1);
        root.right = build(nums, index + 1, end);

        return root;
    }

    // https://leetcode.com/problems/maximum-binary-tree/discuss/106156/Java-worst-case-O(N)-solution
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        final Deque<TreeNode> stack = new LinkedList<>();
        for (int num : nums) {
            TreeNode curr = new TreeNode(num);

            while (!stack.isEmpty() && stack.peek().val < num) curr.left = stack.pop();
            if (!stack.isEmpty()) stack.peek().right = curr;

            stack.push(curr);
        }

        return stack.isEmpty() ? null : stack.removeLast();
    }
}
