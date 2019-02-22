package com.facebook;

public class DotProduct {
    public int dotPro(int[][] v1, int[][] v2) {
        int[][] shortV;
        int[][] longV;
        if (v1.length < v2.length) {
            shortV = v1;
            longV = v2;
        } else {
            shortV = v2;
            longV = v1;
        }

        int res = 0;
        for (int i = 0; i < shortV.length; i++) {
            int shortIndex = shortV[i][0];
            int shortValue = shortV[i][1];
            int longSeq = binarySearch(longV, shortIndex);
            if (longSeq >= 0) {
                res += shortValue * longV[longSeq][1];
            }
        }
        return res;
    }

    public int binarySearch(int[][] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m][0] == target) return m;
            else if (arr[m][0] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DotProduct sol = new DotProduct();
        int[][] v2 = new int[][]{{0, 2}, {1, 3}, {5, 2}, {7, 1}, {10, 1}};
        int[][] v1 = new int[][]{{1, 6}, {7, 2}};
        int res = sol.dotPro(v1, v2);
        System.out.println(res);
    }
}
