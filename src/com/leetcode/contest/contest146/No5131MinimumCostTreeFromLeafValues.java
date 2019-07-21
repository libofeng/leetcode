package com.leetcode.contest.contest146;

import java.util.*;

public class No5131MinimumCostTreeFromLeafValues {
    Map<String, int[]> cache = new HashMap<>();

    public static void main(String[] args) {
        No5131MinimumCostTreeFromLeafValues solution = new No5131MinimumCostTreeFromLeafValues();
        int minSum = solution.mctFromLeafValues2(new int[]{7, 12, 8, 10});
        System.out.println("minSum = " + minSum);
    }

    public int mctFromLeafValues(int[] arr) {
        final int n = arr.length;

        return find(arr, 0, n - 1)[0];
    }

    private int[] find(int[] nums, int start, int end) {
        if (start == end) return new int[]{0, nums[start]};
        String key = start + "-" + end;
        if (cache.containsKey(key)) return cache.get(key);

        int minSum = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            int[] left = find(nums, start, i), right = find(nums, i + 1, end);

            int sum = left[1] * right[1] + left[0] + right[0];
            minSum = Math.min(minSum, sum);
            maxVal = Math.max(maxVal, Math.max(left[1], right[1]));
        }

        int[] result = new int[]{minSum, maxVal};
        cache.put(key, result);
        return result;
    }


    // See also:
    // 503. Next Greater Element II
	// 496. Next Greater Element I
	// 556. Next Greater Element III

    // Time: O(N^3), Space: O(N^2)
    public int mctFromLeafValues2(int[] arr) {
        final int n = arr.length;
        final int[][] maxVal = new int[n][n];
        for (int i = 0; i < n; i++) {
            maxVal[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) maxVal[i][j] = Math.max(maxVal[i][j - 1], arr[j]);
        }

        final int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = Integer.MAX_VALUE;
                for (int k = i; k > j; k--) {
                    int left = dp[j][k - 1], right = dp[k][i];
                    int sum = left + right + maxVal[j][k - 1] * maxVal[k][i];
                    dp[j][i] = Math.min(dp[j][i], sum);
                }
            }
        }

        return dp[0][n - 1];
    }

    // Time: O(N^2), Space: O(N)
    public int mctFromLeafValues3(int[] arr) {
        final Map<Integer, List<Integer>> tm = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) tm.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);

        int sum = 0;
        final Set<Integer> used = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> e : tm.entrySet()) {
            int n = e.getKey();
            for (int index : e.getValue()) {
                used.add(index);
                int lo = index, hi = index;

                while (lo >= 0 && used.contains(lo)) lo--;
                while (hi < arr.length && used.contains(hi)) hi++;

                if (lo < 0 && hi >= arr.length) continue;

                if (lo >= 0 && hi < arr.length) {
                    if (arr[lo] < arr[hi]) sum += n * arr[lo];
                    else sum += n * arr[hi];
                } else if (lo >= 0) sum += n * arr[lo];
                else sum += n * arr[hi];
            }
        }

        return sum;
    }
}
