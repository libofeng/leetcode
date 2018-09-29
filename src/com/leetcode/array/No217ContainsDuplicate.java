package com.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No217ContainsDuplicate {
    // sorting
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) if (nums[i] == nums[i - 1]) return true;

        return false;
    }

    // set
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }
}
