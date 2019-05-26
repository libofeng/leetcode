package com.leetcode.contest.contest138;

import java.util.Arrays;

public class No1051HeightChecker {
    public int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        Arrays.sort(sorted);

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (sorted[i] != heights[i]) count++;
        }
        return count;
    }
}
