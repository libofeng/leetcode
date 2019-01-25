package com.leetcode.array;

import java.util.*;

public class No18KSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int k, int start) {
        if (k == 2) return twoSum(nums, target, start);
        final List<List<Integer>> result = new ArrayList<>();
        final int n = nums.length;

        for (int i = start; i < n; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            List<List<Integer>> tmp = kSum(nums, target - nums[i], k - 1, i + 1);
            for (List<Integer> list : tmp) {
                list.add(nums[i]);
                result.add(list);
            }
        }

        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        final List<List<Integer>> result = new ArrayList<>();
        final int n = nums.length;

        int lo = start, hi = n - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum == target) {
                List<Integer> r = new ArrayList<>();
                r.add(nums[lo]);
                r.add(nums[hi]);
                result.add(r);

                lo++;
                hi--;
                while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
                while (lo < hi && nums[hi] == nums[hi + 1]) hi--;
            } else if (sum < target) {
                lo++;
                while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
            } else {
                hi--;
                while (lo < hi && nums[hi] == nums[hi + 1]) hi--;
            }
        }

        return result;
    }
}
