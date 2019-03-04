package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class No228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        final List<String> result = new ArrayList<>();
        final int n = nums.length;
        if (nums.length == 0) return result;

        int start = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                result.add(buildRange(start, nums[i - 1]));
                start = nums[i];
            }
        }
        result.add(buildRange(start, nums[n - 1]));

        return result;
    }

    private String buildRange(int start, int end) {
        return start == end ? (start + "") : (start + "->" + end);
    }
}
