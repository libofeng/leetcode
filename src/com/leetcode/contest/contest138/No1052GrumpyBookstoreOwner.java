package com.leetcode.contest.contest138;

public class No1052GrumpyBookstoreOwner {
    // Sliding window
    // Time: O(N), Space: O(1)
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        final int n = customers.length;

        int total = 0;
        for (int customer : customers) total += customer;

        int grumpyTotal = 0;
        for (int i = 0; i < n; i++) if (grumpy[i] == 1) grumpyTotal += customers[i];

        int max = Integer.MIN_VALUE, windowSum = 0, start = -1;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) windowSum += customers[i];
            if (i - start == X) {
                max = Math.max(max, windowSum);
                start++;
                if (grumpy[start] == 1) windowSum -= customers[start];
            }
        }

        return total - grumpyTotal + max;
    }
}
