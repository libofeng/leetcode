package com.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class No973KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, K);
    }
}
