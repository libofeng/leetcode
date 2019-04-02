package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class No325MaximumSizeSubarraySumEqualsK {
    /*
    Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

    Note:
    The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

    Example 1:

    Input: nums = [1, -1, 5, -2, 3], k = 3
    Output: 4
    Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
    Example 2:

    Input: nums = [-2, -1, 2, 1], k = 1
    Output: 2
    Explanation: The subarray [-1, 2] sums to 1 and is the longest.
    Follow Up:
    Can you do it in O(n) time?
     */

    int findMaxSize(int[] nums, int k) {
        final int n = nums.length;
        final int[] sums = new int[n + 1];

        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + nums[i - 1];

        for (int i = 0; i < sums.length; i++) {
            for (int j = n; j > i; j--) if (sums[j] - sums[i] == k) return j - i;
        }

        return 0;
    }

    int findMaxSize2(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0, maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int index = map.getOrDefault(sum - k, i);
            maxSize = Math.max(maxSize, i - index);

            map.putIfAbsent(sum, i);
        }

        return maxSize;
    }

    public static void main(String[] args) {
        No325MaximumSizeSubarraySumEqualsK solution = new No325MaximumSizeSubarraySumEqualsK();
        int len = solution.findMaxSize(new int[]{1, -1, 5, -2, 3}, 3);
        System.out.println("len==4? " + (len == 4));
        len = solution.findMaxSize(new int[]{-2, -1, 2, 1}, 1);
        System.out.println("len==2? " + (len == 2));

        len = solution.findMaxSize2(new int[]{1, -1, 5, -2, 3}, 3);
        System.out.println("len==4? " + (len == 4));
        len = solution.findMaxSize2(new int[]{-2, -1, 2, 1}, 1);
        System.out.println("len==2? " + (len == 2));
    }
}
