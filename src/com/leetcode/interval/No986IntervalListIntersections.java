package com.leetcode.interval;

import java.util.ArrayList;
import java.util.List;

public class No986IntervalListIntersections {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return new Interval[]{};
        }

        int m = A.length, n = B.length;
        int i = 0, j = 0;
        List<Interval> res = new ArrayList<>();
        while (i < m && j < n) {
            Interval a = A[i];
            Interval b = B[j];

            // find the overlap... if there is any...
            int startMax = Math.max(a.start, b.start);
            int endMin = Math.min(a.end, b.end);

            if (endMin >= startMax) {
                res.add(new Interval(startMax, endMin));
            }

            //update the pointer with smaller end value...
            if (a.end == endMin) {
                i++;
            }
            if (b.end == endMin) {
                j++;
            }
        }

        //thanks EOAndersson for the concice expression of converting a list to an array
        //thanks Sithis for the explaination of using toArray (new T[0]) intead fo toArray newT[size])
        return res.toArray(new Interval[0]);
    }

//        int size = res.size();
//        Interval[] list = new Interval[size];
//        for (int k = 0; k < size; k++) {
//            list[k] = res.get(k);
//        }
//        return list;

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        final List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int[] a = A[i], b = B[j];

            int[] ab = intersection(a, b);
            if (ab != null) list.add(ab);

            if (a[0] < b[0]) i++;
            else j++;
        }

        return list.toArray(new int[list.size()][2]);
    }

    private int[] intersection(int[] a, int[] b) {
        if (a[1] < b[0] || a[0] > b[1]) return null;
        return new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};
    }
}
