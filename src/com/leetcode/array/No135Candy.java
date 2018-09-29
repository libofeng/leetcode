package com.leetcode.array;

public class No135Candy {
    public int candy(int[] ratings) {
        int[] R = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            R[i] = 1;
            if (i > 0 && ratings[i - 1] < ratings[i]) R[i] = R[i - 1] + 1;
        }

        int sum = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i + 1] < ratings[i]) R[i] = Math.max(R[i], R[i + 1] + 1);
            sum += R[i];
        }

        return sum;
    }
}
