package com.leetcode.array;

public class No11ContainerWithMostWater {
    // https://www.cnblogs.com/whu-gbf/p/9173582.html
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while (left < right) {
            if (height[left] < height[right]) maxArea = Math.max(maxArea, (right - left) * height[left++]);
            else maxArea = Math.max(maxArea, (right - left) * height[right--]);
        }

        return maxArea;
    }
}
