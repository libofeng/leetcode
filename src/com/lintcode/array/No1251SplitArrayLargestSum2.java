package com.lintcode.array;

public class No1251SplitArrayLargestSum2 {
    private long minGroupSum = Integer.MAX_VALUE;

    public int splitArray(int[] nums, int m) {
        dfs(nums, m, 1, 0, 0, 0);
        return (int) minGroupSum;
    }

    private void dfs(int[] nums, int m, int count, long maxSum, long sum, int index) {
        if (index >= nums.length) {
            if (count == m) {
                maxSum = Math.max(maxSum, sum);
                minGroupSum = Math.min(minGroupSum, maxSum);
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            sum += nums[i];
            dfs(nums, m, count, maxSum, sum, i + 1);
            dfs(nums, m, count + 1, Math.max(maxSum, sum), 0, i + 1);
        }
    }

    public static void main(String[] args) {
        No1251SplitArrayLargestSum2 solution = new No1251SplitArrayLargestSum2();
        int min = solution.splitArray(new int[]{1, 2147483647}, 2);
        System.out.println("min = " + min);
    }
}
