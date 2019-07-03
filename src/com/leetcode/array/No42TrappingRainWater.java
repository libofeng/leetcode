package com.leetcode.array;

import java.util.Stack;

public class No42TrappingRainWater {
    // https://www.cnblogs.com/grandyang/p/4402392.html
    // DP
    public int trap(int[] height) {
        final int n = height.length;
        if (n < 3) return 0;

        final int[] leftMax = new int[n], rightMax = new int[n];
        for (int i = 1; i < n; i++) leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
        for (int i = n - 2; i >= 0; i--) rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);

        int total = 0;
        for (int i = 1; i < n - 1; i++) total += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);

        return total;
    }

    // 2 pointers
    public int trap2(int[] height) {
        int max = 0, left = 0, right = height.length - 1, total = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                max = Math.max(max, height[left]);
                total += max - height[left++];
            } else {
                max = Math.max(max, height[right]);
                total += max - height[right--];
            }
        }

        return total;
    }

    public int trap3(int[] height) {
        int len = height.length;
        if (len <= 2) return 0;
        int peakIndex = 0;
        for (int i = 1; i < len; i++) if (height[i] > height[peakIndex]) peakIndex = i;

        int water = 0;
        int leftPeak = height[0];
        for (int i = 1; i < peakIndex; i++) {
            leftPeak = Math.max(leftPeak, height[i]);
            water += Math.min(leftPeak, height[peakIndex]) - height[i];
        }
        int rightPeak = height[len - 1];
        for (int i = len - 2; i > peakIndex; i--) {
            rightPeak = Math.max(rightPeak, height[i]);
            water += Math.min(rightPeak, height[peakIndex]) - height[i];
        }


        return water;
    }

    // stack
    public int trap4(int[] height) {
        if (height.length <= 2) return 0;

        int water = 0;
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; ) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) stack.push(i++);
            else {
                int h = height[stack.pop()];
                if (stack.isEmpty()) continue;
                water += (Math.min(height[i], height[stack.peek()]) - h) * (i - stack.peek() - 1);
            }
        }

        return water;
    }
}
