package com.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;
        Arrays.sort(nums);

        int maxLen = 1, len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            len = nums[i] == nums[i - 1] + 1 ? (len + 1) : 1;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int lo = nums[i], hi = nums[i] + 1;
            while (set.remove(lo)) lo--;
            while (set.remove(hi)) hi++;

            maxLen = Math.max(maxLen, hi - lo - 1);
        }

        return maxLen;
    }
}
