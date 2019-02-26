package com.facebook;

import java.util.ArrayList;
import java.util.List;

public class FindIntersections {

    public List<Interval> intersection(Interval[] A, Interval[] B) {
        final List<Interval> result = new ArrayList<>();
        final int lenA = A.length, lenB = B.length;

        for (int i = 0, j = 0; i < lenA && j < lenB; ) {
            Interval overlap = intersection(A[i], B[j]);

            if (overlap != null) result.add(overlap);

            if (A[i].end < B[j].end) i++;
            else if (A[i].end > B[j].end) j++;
            else {
                if (i == lenA - 1 || j == lenB - 1) {
                    if (i == lenA - 1) j++;
                    else i++;
                } else if (A[i + 1].start < B[j + 1].start) i++;
                else if (A[i + 1].start > B[j + 1].start) j++;
                else {
                    i++;
                    j++;
                }
            }
        }

        return result;
    }

    private Interval intersection(Interval a, Interval b) {
        if (a.start >= b.end || b.start >= a.end) return null;

        int start = Math.max(a.start, b.start);
        int end = Math.min(a.end, b.end);
        return new Interval(start, end);
    }

    public static void main(String[] args) {
        Interval[] A = new Interval[]{new Interval(3, 4), new Interval(5, 6), new Interval(7, 10)};
        Interval[] B = new Interval[]{new Interval(1, 2), new Interval(3, 6), new Interval(9, 12)};
        FindIntersections solution = new FindIntersections();
        List<Interval> result = solution.intersection(A, B);
        System.out.println("result = " + result);
    }
}
