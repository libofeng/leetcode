package com.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No219ContainsDuplicateII {
    // set
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) return false;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        return false;
    }

    // map
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int prevIndex = map.get(nums[i]);
                if (i - prevIndex <= k) return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }

}
