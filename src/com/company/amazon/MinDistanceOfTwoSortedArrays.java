package com.company.amazon;

public class MinDistanceOfTwoSortedArrays {
    private int findMinDistance(int[] a1, int[] a2) {
        if (a1.length == 0 && a2.length == 0) return 0;
        if (a1.length == 0 || a2.length == 0) return Math.abs(a1.length == 0 ? a2[0] : a1[0]);

        int i = 0, j = 0, minDistance = Integer.MAX_VALUE;
        while (i < a1.length && j < a2.length) {
            int d = Math.abs(a1[i] - a2[j]);
            if (d == 0) return d;

            minDistance = Math.min(minDistance, d);
            if (a1[i] < a2[j]) i++;
            else j++;
        }

        return minDistance;
    }

    public static void main(String[] args) {
        MinDistanceOfTwoSortedArrays solution = new MinDistanceOfTwoSortedArrays();
        int[] A1 = new int[]{3, 9, 20, 27};
        int[] A2 = new int[]{1, 10, 30, 40};
        int minDistance = solution.findMinDistance(A1, A2);
        System.out.println("minDistance = " + minDistance);
    }
}
