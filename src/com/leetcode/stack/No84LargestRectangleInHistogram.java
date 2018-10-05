package com.leetcode.stack;

import java.util.Stack;

public class No84LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int minH = heights[i];
            for (int j = i; j < heights.length; j++) {
                minH = Math.min(minH, heights[j]);
                max = Math.max(max, minH * (j - i + 1));
            }
        }

        return max;
    }

    public int largestRectangleArea2(int[] heights) {
        final Stack<Integer> stack = new Stack<>();

        int max = 0, i = 0;
        while (i <= heights.length) {
            int h = i < heights.length ? heights[i] : 0;
            if (stack.isEmpty() || h >= heights[stack.peek()]) stack.push(i++);
            else {
                int height = heights[stack.pop()];
                max = Math.max(max, height * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        return max;
    }
}
