package com.leetcode.contest.contest129;

public class No1020PartitionArrayIntoThreePartsWithEqualSum {
    /*
    Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.

    Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])



    Example 1:

    Input: [0,2,1,-6,6,-7,9,1,2,0,1]
    Output: true
    Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
    Example 2:

    Input: [0,2,1,-6,6,7,9,-1,2,0,1]
    Output: false
    Example 3:

    Input: [3,3,6,5,-2,2,5,1,-9,4]
    Output: true
    Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4

     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int n : A) sum += n;
        if (sum % 3 != 0) return false;
        int partSum = sum / 3;

        int p1 = 0;
        sum = 0;
        while (p1 < A.length && sum != partSum) sum += A[p1++];
        if (p1 >= A.length - 1) return false;

        int p2 = p1;
        sum = 0;
        while (p2 < A.length && sum != partSum) sum += A[p2++];

        return p2 <= A.length - 1;
    }
}
