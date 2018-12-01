package com.lintcode.array;

import java.util.ArrayList;
import java.util.List;

public class No249CountOfSmallerNumberBeforeItSelfBIT {

    private int n;
    private int[] BIT;

    /**
     * @param A: an integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> countOfSmallerNumberII(int[] A) {
        this.n = 10000;
        this.BIT = new int[n + 1];

        List<Integer> result = new ArrayList<>();
        if (A == null || A.length == 0) return result;

        for (int num : A) {
            add(num);
            result.add(preSum(num - 1));
        }

        return result;
    }

    private void add(int i) {
        for (i++; i <= n; i += (i & -i)) BIT[i] += 1;
    }

    private int preSum(int i) {
        int sum = 0;
        for (i++; i > 0; i -= (i & -i)) sum += BIT[i];
        return sum;
    }
}
