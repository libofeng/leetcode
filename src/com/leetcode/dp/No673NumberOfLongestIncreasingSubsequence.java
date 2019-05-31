package com.leetcode.dp;

import java.util.Arrays;

public class No673NumberOfLongestIncreasingSubsequence {
    // Time: O(N^2), Space: O(n)
    public int findNumberOfLIS(int[] nums) {
        final int n = nums.length;
        if(n == 0) return 0;

        final int[] dp = new int[n], count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxLen = 0, maxCount = 0;
        for(int i = 0;i<n;i++){
            for(int j = i-1;j>=0;j--){
                if(nums[i]<=nums[j]) continue;

                if(dp[j] + 1> dp[i]){
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }else if(dp[j] + 1 == dp[i]) count[i] += count[j];
            }

            if(dp[i]>maxLen){
                maxLen = dp[i];
                maxCount = count[i];
            }else if(dp[i] == maxLen) maxCount+=count[i];
        }

        return maxCount;
    }
}
