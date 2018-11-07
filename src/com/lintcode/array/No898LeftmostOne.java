package com.lintcode.array;

public class No898LeftmostOne {
    /**
     * @param arr: The 2-dimension array
     * @return: Return the column the leftmost one is located
     */
    public int getColumn(int[][] arr) {
        final int m = arr.length, n = m == 0 ? 0 : arr[0].length;
        for (int j = 0; j < n; j++) for (int[] A : arr) if (A[j] == 1) return j;

        return n;
    }

    public int getColumn2(int[][] arr) {
        int m = arr.length, n = m == 0 ? 0 : arr[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (arr[x][y] == 1) y--;
            else x++;
        }
        return y + 1;
    }
}
