package com.leetcode.array;

import java.util.TreeSet;

public class No220ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2 || k <= 0 || t < 0) return false;

        final TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long n = nums[i];
            if (!set.add(n)) return true;
            Long floor = set.floor(n + t), ceiling = set.ceiling(n - t);
            if ((floor != null && floor > n) || (ceiling != null && ceiling < n)) return true;

            if (set.size() > k) set.remove((long) nums[i - k]);
        }

        return false;
    }
}
