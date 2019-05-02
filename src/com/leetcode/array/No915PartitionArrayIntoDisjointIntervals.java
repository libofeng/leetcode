package com.leetcode.array;

public class No915PartitionArrayIntoDisjointIntervals {

    public int partitionDisjoint(int[] A) {
        final int n = A.length;
        int[] rightMin = new int[n];

        int min = A[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, A[i]);
            rightMin[i] = min;
        }

        int index = 1, max = A[0];
        while (index < n) {
            if (max <= rightMin[index]) break;

            max = Math.max(max, A[index]);
            index++;
        }

        return index;
    }

    public int partitionDisjoint2(int[] A) {
        int localMax = A[0], partitionIdx = 0, max = localMax;
        for (int i = 1; i < A.length; i++)
            if (localMax > A[i]) {
                localMax = max;
                partitionIdx = i;
            } else max = Math.max(max, A[i]);
        return partitionIdx + 1;
    }

}
