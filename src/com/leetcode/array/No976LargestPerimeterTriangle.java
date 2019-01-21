package com.leetcode.array;

import java.util.Arrays;

public class No976LargestPerimeterTriangle {
    // we can just follow the constrain to construct a triangle, which is:
    // a + b > c (a<c && b < c)

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i > 1; i--) if (A[i - 2] + A[i - 1] > A[i]) return A[i] + A[i - 1] + A[i - 2];
        return 0;
    }
}
