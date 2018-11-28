package com.lintcode.array;

import java.util.Arrays;
import java.util.List;

public class No402ContinuousSubarraySum {
    /*
     * @param A: An integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> continuousSubarraySum(int[] A) {
        int[] minIndex = new int[A.length + 1], sum = new int[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
            minIndex[i] = sum[minIndex[i - 1]] <= sum[i] ? minIndex[i - 1] : i;
        }

        int maxStart = 0, maxEnd = 1, max = Integer.MIN_VALUE;
        for (int i = 1; i <= A.length; i++) {
            if (sum[i] - sum[minIndex[i - 1]] > max) {
                max = sum[i] - sum[minIndex[i - 1]];
                maxStart = minIndex[i - 1];
                maxEnd = i;
            }
        }

        return Arrays.asList(maxStart, maxEnd - 1);
    }
}
