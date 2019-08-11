package com.leetcode.contest.contest149;

public class No1157OnlineMajorityElementInSubarray {
    int[] arr;

    public No1157OnlineMajorityElementInSubarray(int[] arr) {
        this.arr = arr;
    }

    // similar to No.169
    // see: 169. Majority Element
    // see: 1150. Check If a Number Is Majority Element in a Sorted Array
    // see: 961. N-Repeated Element in Size 2N Array
    public int query(int left, int right, int threshold) {
        int candidate = -1, count = 0;
        for (int i = left; i <= right; i++) {
            if (arr[i] == candidate) count++;
            else {
                count--;
                if (count == -1) {
                    candidate = arr[i];
                    count = 1;
                }
            }
        }

        // validate candidate
        int c = 0;
        for (int i = left; i <= right; i++) if (arr[i] == candidate) c++;

        return c >= threshold ? candidate : -1;
    }
}
