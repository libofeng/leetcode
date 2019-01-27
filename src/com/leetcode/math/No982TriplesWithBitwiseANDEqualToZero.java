package com.leetcode.math;

public class No982TriplesWithBitwiseANDEqualToZero {
    // https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/discuss/226721/Java-DP-O(3-*-216-*-n)-time-O(n)-space
    public int countTriplets(int[] A) {
        int N = 1 << 16;
        int[] dp = new int[N];
        dp[N - 1] = 1;
        for (int i = 0; i < 3; i++) {
            int[] temp = new int[N];
            for (int k = 0; k < N; k++) {
                for (int a : A) {
                    temp[k & a] += dp[k];
                }
            }
            dp = temp;
        }
        return dp[0];
    }
}
