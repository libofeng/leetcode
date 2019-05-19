package com.leetcode.tree;

public class No440KthSmallestInLexicographicalOrder {
    // https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/discuss/92242/ConciseEasy-to-understand-Java-5ms-solution-with-Explaination
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--;
        while (k > 0) {
            int steps = calSteps(n, current, current + 1);
            if (steps <= k) {
                k -= steps;
                current++;
            } else {
                k--;
                current *= 10;
            }
        }

        return current;
    }

    private int calSteps(int n, long start, long end) {
        int steps = 0;

        while (start <= n) {
            steps += Math.min(n + 1, end) - start;
            start *= 10;
            end *= 10;
        }

        return steps;
    }
}
