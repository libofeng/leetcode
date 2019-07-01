package com.leetcode.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No368LargestDivisibleSubset {
    // Time: O(N^2), Space: O(N)
    public List<Integer> largestDivisibleSubset(int[] nums) {
        final int n = nums.length;
        Arrays.sort(nums);

        final int[] count = new int[n], prev = new int[n];
        int index = -1, max = 0;
        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (count[j] + 1 > count[i]) {
                        count[i] = count[j] + 1;
                        prev[i] = j;
                    }
                }
            }

            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }

        final List<Integer> result = new ArrayList<>();
        while (index != -1) {
            result.add(nums[index]);
            index = prev[index];
        }
        return result;
    }
}
