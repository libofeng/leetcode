package com.leetcode.array;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class No329LongestIncreasingPathInAMatrix {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        int[][] cache = new int[m][n];

        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j] - 1;
                maxLen = Math.max(maxLen, dfs(matrix, cache, i, j, val));
            }
        }

        return maxLen;
    }

    private int dfs(int[][] matrix, int[][] cache, int x, int y, int val) {
        final int m = matrix.length, n = matrix[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= val) return 0;
        if (cache[x][y] > 0) return cache[x][y];

        val = matrix[x][y];
        for (int[] dir : dirs) {
            cache[x][y] = Math.max(cache[x][y], dfs(matrix, cache, x + dir[0], y + dir[1], val));
        }
        cache[x][y]++;

        return cache[x][y];
    }

    // dp
    public int longestIncreasingPath2(int[][] matrix) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        List<int[]> list = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) list.add(new int[]{i, j, matrix[i][j]});
        }

        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        };
        list.sort(comparator);

        int[][] dp = new int[m][n];
        int maxLen = 0;
        for (int[] num : list) {
            int i = num[0], j = num[1], val = num[2], max = 0;
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && val > matrix[x][y]) max = Math.max(max, dp[x][y]);
            }
            dp[i][j] = max + 1;
            maxLen = Math.max(maxLen, dp[i][j]);
        }

        return maxLen;
    }
}
