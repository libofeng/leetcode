package com.leetcode.contest.contest126;

public class No1000MinimumCostToMergeStones {
    // this is NOT right solution

    public int mergeStones(int[] stones, int K) {
        if (stones.length <= 1) return 0;
        if (stones.length < K) return -1;

        int minSum = Integer.MAX_VALUE, minStart = -1, start = -1, sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
            if (i - start == K) {
                if (sum <= minSum) {
                    minSum = sum;
                    minStart = ++start;
                }

                sum -= stones[start];
            }
        }

        int[] list = new int[stones.length - K + 1];
        for (int i = 0, j = 0; i < list.length; i++) {
            if (i == minStart) {
                list[i] = minSum;
                j += K;
            } else {
                list[i] = stones[j];

                j++;
            }
        }

        int next = mergeStones(list, K);
        return next == -1 ? -1 : minSum + next;
    }
}
