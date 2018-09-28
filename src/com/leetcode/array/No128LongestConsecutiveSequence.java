package com.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;

        Arrays.sort(nums);
        int maxLen = 1, len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] != nums[i - 1] + 1) len = 0;

            len++;
            maxLen = Math.max(len, maxLen);
        }

        return maxLen;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums.length <= 1) return nums.length;

        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int maxLen = 0;
        for (int n : nums) {
            if (!set.contains(n)) continue;

            set.remove(n);
            int min = n, max = n;
            while (set.contains(min - 1)) set.remove(--min);
            while (set.contains(max + 1)) set.remove(++max);

            maxLen = Math.max(maxLen, (max - min + 1));
        }

        return maxLen;
    }
}
