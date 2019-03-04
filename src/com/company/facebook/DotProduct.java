package com.company.facebook;

import java.util.Arrays;

public class DotProduct {
    public int dotPro(int[][] vectorA, int[][] vectorB) {
        if (vectorA.length > vectorB.length) return dotPro(vectorB, vectorA);
        Arrays.sort(vectorB, (a, b) -> a[0] - a[1]);

        int res = 0;
        for (int[] v : vectorA) {
            int index = v[0], n1 = v[1];

            int idx = binarySearch(vectorB, index);
            if (idx >= 0) res += n1 * vectorB[idx][1];
        }
        return res;
    }

    private int binarySearch(int[][] vector, int target) {
        int lo = 0, hi = vector.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (vector[mid][0] == target) return mid;

            if (target < vector[mid][0]) hi = mid - 1;
            else lo = mid + 1;
        }

        return -1;
    }


    public static void main(String[] args) {
        DotProduct sol = new DotProduct();
        int[][] v2 = new int[][]{{1, 3}, {0, 2}, {5, 2}, {7, 1}, {10, 1}};
        int[][] v1 = new int[][]{{1, 6}, {7, 2}};
        int res = sol.dotPro(v1, v2);
        System.out.println(res);
    }
}
