package com.leetcode.dp;

import java.util.Arrays;
import java.util.Stack;

public class No85MaximalRectangle {

    // brute force
    public int maximalRectangle(char[][] matrix) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) maxArea = Math.max(maxArea, findMax(matrix, i, j));
        }

        return maxArea;
    }

    private int findMax(char[][] matrix, int row, int col) {
        int maxArea = 0, maxCol = matrix[0].length;

        for (int i = row; i < matrix.length; i++) {
            for (int j = col; j < maxCol; j++) if (matrix[i][j] == '0') maxCol = j;
            maxArea = Math.max(maxArea, (i - row + 1) * (maxCol - col));
        }

        return maxArea;
    }


    // use Stack like max area in Histogram
    public int maximalRectangle2(char[][] matrix) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;

        int maxArea = 0;
        int[] heights = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) heights[j] = matrix[i][j] == '1' ? (heights[j] + 1) : 0;
            maxArea = Math.max(maxArea, findMax(heights));
        }

        return maxArea;
    }

    private int findMax(int[] heights) {
        int maxArea = 0;
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; ) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) stack.push(i++);
            else {
                int h = heights[stack.pop()];
                maxArea = Math.max(maxArea, h * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
            }
        }

        return maxArea;
    }

    // https://blog.csdn.net/maxiaotiaoti/article/details/62230381
    public int maximalRectangle3(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        final int m = matrix.length, n = matrix[0].length;
        final int[] left = new int[n], right = new int[n], height = new int[n];
        Arrays.fill(right, n);

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            int cLeft = 0, cRight = n;
            for (int j = 0; j < n; j++) {
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], cLeft);
                else {
                    left[j] = 0;
                    cLeft = j + 1;
                }
            }

            // mind the direction, from right to left
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], cRight);
                else {
                    right[j] = n;
                    cRight = j;
                }
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }

        return maxArea;
    }
}
