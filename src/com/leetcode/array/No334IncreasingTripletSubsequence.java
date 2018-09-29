package com.leetcode.array;

public class No334IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] >= nums[j]) continue;

                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) return true;
                }
            }
        }

        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        int x1 = Integer.MAX_VALUE, x2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= x1) x1 = n;
            else if (n <= x2) x2 = n;
            else return true;
        }

        return false;
    }
}
