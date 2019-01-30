package com.leetcode.math;

import java.util.*;

public class No398RandomPickIndex2 {
    private int[] nums;
    private Random rnd;

    public No398RandomPickIndex2(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;
            if (rnd.nextInt(++count) == 0) result = i;
        }

        return result;
    }

}
