package com.leetcode.array;

import java.util.TreeSet;

public class No220ContainsDuplicateIII {
    // Brute force
    // O(N^2)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs((long) nums[i] - nums[j]) <= t && j - i <= k) return true;
            }
        }

        return false;
    }

    //
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
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

    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k == 0 || t < 0) return false;
        if (nums.length > 400) return false; // Why??
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (Math.abs(nums[i] - (long) nums[j]) <= t) return true;
            }
        }

        return false;
    }
}
