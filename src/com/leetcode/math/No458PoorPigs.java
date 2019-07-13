package com.leetcode.math;

public class No458PoorPigs {
    // https://leetcode.com/problems/poor-pigs/discuss/94266/Another-explanation-and-solution
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0, canTest = minutesToTest / minutesToDie + 1, total = 1;
        while (total < buckets) {
            pigs++;
            total *= canTest;
        }

        return pigs;
    }
}
