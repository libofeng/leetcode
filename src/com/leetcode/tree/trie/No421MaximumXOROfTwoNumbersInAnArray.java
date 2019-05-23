package com.leetcode.tree.trie;

import java.util.HashSet;
import java.util.Set;

public class No421MaximumXOROfTwoNumbersInAnArray {
    // Time: O(N^2), Space: O(1)
    public int findMaximumXOR(int[] nums) {
        final int n = nums.length;

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) max = Math.max(max, nums[i] ^ nums[j]);
        }

        return max;
    }

    // Time: O(N), Space: O(N)
    // prefix
    // try to find the max bit by bit, use a set to fast test if a bit of max can be 1
    public int findMaximumXOR2(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= 1 << i;
            Set<Integer> set = new HashSet<>();
            for (int n : nums) set.add(n & mask);

            int nextMax = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(prefix ^ nextMax)) {
                    max = nextMax;
                    break;
                }
            }
        }

        return max;
    }
}
