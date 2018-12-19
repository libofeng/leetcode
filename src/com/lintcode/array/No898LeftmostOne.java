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
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (arr[i][j] == 1) j--;
            else i++;
        }
        return j + 1;
    }
}
