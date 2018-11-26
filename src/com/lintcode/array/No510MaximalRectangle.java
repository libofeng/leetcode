package com.lintcode.array;

import java.util.Arrays;
import java.util.Stack;

public class No510MaximalRectangle {
    /**
     * @param matrix: a boolean 2D matrix
     * @return: an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) maxArea = Math.max(maxArea, findMax(matrix, i, j));
        }

        return maxArea;
    }

    private int findMax(boolean[][] matrix, int row, int col) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        int maxArea = 0, maxRight = n;
        for (int i = row; i < m && matrix[i][col]; i++) {
            for (int j = col; j < maxRight; j++) if (!matrix[i][j]) maxRight = j;
            maxArea = Math.max(maxArea, (maxRight - col) * (i - row + 1));
        }

        return maxArea;
    }

    public int maximalRectangle2(boolean[][] matrix) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        int maxArea = 0;
        final int[] heights = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) heights[j] = matrix[i][j] ? heights[j] + 1 : 0;
            maxArea = Math.max(maxArea, findMax(heights));
        }

        return maxArea;
    }

    private int findMax(int[] heights) {
        final Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; ) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) stack.push(i++);
            else {
                int h = heights[stack.pop()];
                maxArea = Math.max(maxArea, h * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
            }
        }

        return maxArea;
    }

    public int maximalRectangle3(boolean[][] matrix) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        final int[] heights = new int[n], left = new int[n], right = new int[n];
        Arrays.fill(right, n);

        int max = 0;
        for (int i = 0; i < m; i++) {

            int cLeft = 0, cRight = n;
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] ? heights[j] + 1 : 0;
                if (matrix[i][j]) left[j] = Math.max(cLeft, left[j]);
                else {
                    left[j] = 0;
                    cLeft = j + 1;
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j]) right[j] = Math.min(cRight, right[j]);
                else {
                    cRight = j;
                    right[j] = n;
                }

                max = Math.max(max, heights[j] * (right[j] - left[j]));
            }
        }

        return max;
    }
}
