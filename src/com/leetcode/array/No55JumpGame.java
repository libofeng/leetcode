package com.leetcode.array;

public class No55JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = nums[0], i = 0;
        while (i <= maxReach && i < nums.length) maxReach = Math.max(maxReach, i + nums[i++]);
        return maxReach >= nums.length - 1;
    }
}
