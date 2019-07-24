package com.company.facebook;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 6}, {7, 9}};
        int[][] b = new int[][]{{1, 2}, {3, 4}, {8, 10}, {12, 16}};

        final MergeInterval solution = new MergeInterval();
        List<int[]> result = solution.merge(a, b);

        System.out.println(result);
    }

    private List<int[]> merge(int[][] a, int[][] b) {
        List<int[]> result = new ArrayList<>();

        int[] current = null;
        for (int i = 0, j = 0; i < a.length || j < b.length; ) {
            int[] next;

            if (i == a.length) next = b[j++];
            else if (j == b.length) next = a[i++];
            else {
                next = compare(a[i], b[j]) <= 0 ? a[i++] : b[j++];
            }

            if (current == null) current = next;
            else {
                if (next[0] <= current[1]) current[1] = Math.max(current[1], next[1]);
                else {
                    result.add(current);
                    current = next;
                }
            }
        }
        if (current != null) result.add(current);

        return result;
    }

    private int compare(int[] a, int[] b) {
        if (a[0] == b[0]) return a[1] - b[1];
        return a[0] - b[0];
    }
}
