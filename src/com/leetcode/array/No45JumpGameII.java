package com.leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No45JumpGameII {
    // dp
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--)
                if (nums[j] + j >= i) dp[i] = Math.min(dp[i], dp[j] + 1);
        }

        return dp[dp.length - 1];
    }

    // BFS
    public int jump2(int[] nums) {
        if (nums.length <= 1) return 0;

        final Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        visited[0] = true;
        q.offer(0);

        int jumps = 0;
        while (!q.isEmpty()) {
            jumps++;
            int size = q.size();
            while (size-- > 0) {
                int p = q.poll(), k = nums[p];
                if (p + k >= nums.length - 1) return jumps;

                for (int i = 1; i <= k; i++) {
                    if (!visited[p + i]) {
                        q.offer(p + i);
                        visited[p + i] = true;
                    }
                }
            }
        }

        return 0;
    }

    // greedy
    // https://www.cnblogs.com/grandyang/p/4373533.html
    public int jump3(int[] nums) {
        int maxReach = 0, nextMax = 0, jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextMax = Math.max(nextMax, i + nums[i]);

            if (i == maxReach) {
                maxReach = nextMax;
                jumps++;

                if (maxReach >= nums.length - 1) break;
            }
        }

        return jumps;
    }
}
