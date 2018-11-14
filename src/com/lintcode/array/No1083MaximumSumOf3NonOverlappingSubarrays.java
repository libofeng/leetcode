package com.lintcode.array;

import java.util.LinkedList;
import java.util.List;

public class No1083MaximumSumOf3NonOverlappingSubarrays {

    /**
     * @param nums: an array
     * @param k: an integer
     * @return: three non-overlapping subarrays with maximum sum
     */
    List<Integer> maxList = null;
    int maxSum = 0;

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        final int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];

        dfs(nums, k, sums, 0, 0, new LinkedList<>());
        return new int[]{maxList.get(0), maxList.get(1), maxList.get(2)};
    }

    private void dfs(int[] nums, int k, int[] sums, int start, int sum, LinkedList<Integer> list) {
        if (list.size() == 3) {
            if (sum > maxSum) {
                maxList = new LinkedList<>(list);
                maxSum = sum;
            }
            return;
        }

        for (int i = start; i <= nums.length - k; i++) {
            list.add(i);
            dfs(nums, k, sums, i + k, sum + sums[i + k] - sums[i], list);
            list.removeLast();
        }
    }

    // https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/discuss/108231/C++Java-DP-with-explanation-O(n)

    public int[] maxSumOfThreeSubarrays2(int[] nums, int k) {
        int n = nums.length, maxsum = 0;
        int[] sum = new int[n + 1], posLeft = new int[n], posRight = new int[n], ans = new int[3];
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + nums[i];
        // DP for starting index of the left max sum interval
        for (int i = k, tot = sum[k] - sum[0]; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > tot) {
                posLeft[i] = i + 1 - k;
                tot = sum[i + 1] - sum[i + 1 - k];
            } else
                posLeft[i] = posLeft[i - 1];
        }
        // DP for starting index of the right max sum interval
        // caution: the condition is ">= tot" for right interval, and "> tot" for left interval
        posRight[n - k] = n - k;
        for (int i = n - k - 1, tot = sum[n] - sum[n - k]; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= tot) {
                posRight[i] = i;
                tot = sum[i + k] - sum[i];
            } else
                posRight[i] = posRight[i + 1];
        }
        // test all possible middle interval
        for (int i = k; i <= n - 2 * k; i++) {
            int l = posLeft[i - 1], r = posRight[i + k];
            int tot = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if (tot > maxsum) {
                maxsum = tot;
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }
}
