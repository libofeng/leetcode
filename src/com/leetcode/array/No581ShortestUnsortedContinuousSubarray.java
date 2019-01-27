package com.leetcode.array;

import java.util.Arrays;

public class No581ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);

        int left = -1, right = nums.length;
        while (left + 1 < right && nums[left + 1] == copy[left + 1]) left++;
        while (left < right - 1 && nums[right - 1] == copy[right - 1]) right--;

        return right - left - 1;
    }
}
