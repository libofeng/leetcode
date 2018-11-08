package com.lintcode.array;

public class No1287IncreasingTripletSubsequence {
    /**
     * @param nums: a list of integers
     * @return: return a boolean
     */
    public boolean increasingTriplet(int[] nums) {
        int n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= n1) n1 = n;
            else if (n <= n2) n2 = n;
            else return true;
        }
        return false;
    }
}
