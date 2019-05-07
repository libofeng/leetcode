package com.leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class No1005MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        No1005MaximizeSumOfArrayAfterKNegations solution = new No1005MaximizeSumOfArrayAfterKNegations();
        int sum = solution.largestSumAfterKNegations(new int[]{-2, 5, 0, 2, -2}, 3);
        System.out.println("sum = " + sum + ", expected: 11");

        sum = solution.largestSumAfterKNegations(new int[]{1, 3, 2, 6, 7, 9}, 3);
        System.out.println("sum = " + sum + ", expected: 26");

    }

    public int largestSumAfterKNegations(int[] A, int K) {
        if (A.length == 0) return 0;
        Arrays.sort(A);

        if (A[0] >= 0 || K == 0) {
            K %= 2;
            int sum = 0;
            for (int n : A) sum += K-- > 0 ? -n : n;
            return sum;
        }

        for (int i = 0; i < A.length; i++) {
            if (K == 0 || A[i] >= 0) continue;

            A[i] = -A[i];
            K--;
        }

        return largestSumAfterKNegations(A, K);
    }

    public int largestSumAfterKNegations2(int[] A, int K) {
        if (A.length == 0) return 0;
        final Queue<Integer> pq = new PriorityQueue<>();
        for (int n : A) pq.offer(n);

        while (K-- > 0) {
            if (pq.peek() >= 0) K %= 2; // optimization
            pq.offer(-pq.poll());
        }

        int sum = 0;
        for (int n : pq) sum += n;
        return sum;
    }
}
