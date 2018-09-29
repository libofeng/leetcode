package com.leetcode.array;

import java.util.TreeSet;

public class No220ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 || t < 0) return false;

        final TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            Integer ceiling = set.ceiling(nums[i]);
            Integer floor = set.floor(nums[i]);

            if (ceiling != null && Math.abs((long) nums[i] - ceiling) <= t) return true;
            if (floor != null && Math.abs((long) nums[i] - floor) <= t) return true;

            set.add(nums[i]);
        }

        return false;
    }
}
