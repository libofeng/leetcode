package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class No163MissingRanges {
    /*
Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]
     */

    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        final List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(buildRange(lower, upper));
            return result;
        }

        final int n = nums.length;
        if (lower < nums[0]) result.add(buildRange(lower, nums[0] - 1));
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] != nums[i - 1] + 1) result.add(buildRange(nums[i - 1] + 1, nums[i] - 1));
        }
        if (upper > nums[n - 1]) result.add(buildRange(nums[n - 1] + 1, upper));

        return result;
    }

    private String buildRange(int start, int end) {
        return start == end ? (start + "") : (start + "->" + end);
    }

    public static void main(String[] args) {
        final int[] nums = new int[]{0, 1, 3, 50, 75};
        No163MissingRanges solution = new No163MissingRanges();
        List<String> missingRange = solution.findMissingRanges(nums, 0, 99);
        System.out.println("missingRange = " + missingRange);
    }
}
