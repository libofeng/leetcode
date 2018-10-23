package com.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class No300LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            max = Math.max(max, dp[i]);
        }

        return max;
    }


    public int lengthOfLIS2(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int n : nums) {
            int index = findIndex(list, n);
            if (index >= list.size()) list.add(n);
            else list.set(index, n);
        }

        return list.size();
    }

    private int findIndex(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) < target) l = mid + 1;
            else r = mid;
        }

        return l;
    }
}
