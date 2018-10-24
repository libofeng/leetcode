package com.leetcode.dp;

import java.util.Arrays;
import java.util.Stack;

public class No85MaximalRectangle {

    // brute force
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        final int m = matrix.length, n = matrix[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) maxArea = Math.max(maxArea, findMaxArea(matrix, i, j));
        }

        return maxArea;
    }

    private int findMaxArea(char[][] matrix, int row, int col) {
        int maxArea = 0;

        int minWidth = Integer.MAX_VALUE;
        for (int i = row; i < matrix.length && matrix[i][col] == '1'; i++) {
            int j = col;
            while (j < matrix[0].length && matrix[i][j] == '1') j++;
            minWidth = Math.min(minWidth, j - col);

            maxArea = Math.max((i - row + 1) * minWidth, maxArea);
        }
        return maxArea;
    }


    // use Stack like max area in Histogram
    public int maximalRectangle2(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        final int m = matrix.length, n = matrix[0].length;

        final int[][] heights = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') heights[i][j] = i == 0 ? 1 : heights[i - 1][j] + 1;
            }
        }

        int maxArea = 0;
        for (int[] h : heights) maxArea = Math.max(findMaxArea(h), maxArea);

        return maxArea;
    }


    private int findMaxArea(int[] heights) {
        int maxArea = 0;
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; ) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
                continue;
            }

            int h = heights[stack.pop()];
            maxArea = Math.max(maxArea, h * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
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
