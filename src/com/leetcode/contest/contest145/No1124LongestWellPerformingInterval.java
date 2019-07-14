package com.leetcode.contest.contest145;

import java.util.HashMap;
import java.util.Map;

public class No1124LongestWellPerformingInterval {

    // Time: O(N^2), Space: O(N)
    public int longestWPI(int[] hours) {
        final int n = hours.length;
        final int[] tirings = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (hours[i] > 8) count++;
            tirings[i] = count;
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int len = i - j + 1;
                count = tirings[i] - (j == 0 ? 0 : tirings[j - 1]);
                if (count > len - count) maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }

    // https://www.geeksforgeeks.org/longest-subarray-count-1s-one-count-0s/
    // Time: O(N), Space: O(N)
    public int longestWPI2(int[] hours) {
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0, maxLen = 0;
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;

            if (sum > 0) maxLen = i + 1;
            else {
                map.putIfAbsent(sum, i);
                if (map.containsKey(sum - 1)) maxLen = Math.max(maxLen, i - map.get(sum - 1));
            }
        }

        return maxLen;
    }
}
