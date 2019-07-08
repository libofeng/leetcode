package com.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class No503NextGreaterElementII {
    // Brute force solution
    // Time: O(N^2)
    public int[] nextGreaterElements(int[] nums) {
        final int n = nums.length;
        final int[] result = new int[n];
        for (int i = 0; i < nums.length; i++) {
            int index = (i + 1) % n;
            while (index != i && nums[index] <= nums[i]) index = ++index % n;
            result[i] = index == i ? -1 : nums[index];
        }

        return result;
    }

    // Time: O(N), Space: O(N)
    public int[] nextGreaterElements2(int[] nums) {
        final int n = nums.length;
        final int[] result = new int[n];
        final Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) stack.push(i);
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) stack.pop();
            result[i] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i);
        }

        return result;
    }
}
