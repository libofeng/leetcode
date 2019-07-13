package com.leetcode.contest.biweekly.contest4;

public class No1120MaximumAverageSubtree {
    private double maxAvg = Double.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return maxAvg;
    }

    private Double[] dfs(TreeNode root) {
        if (root == null) return new Double[]{0D, 0D};

        Double[] left = dfs(root.left), right = dfs(root.right);
        double sum = root.val, count = 1;
        if (left[1].compareTo(0D) > 0) {
            sum += left[0];
            count += left[1];
        }

        if (right[1].compareTo(0D) > 0) {
            sum += right[0];
            count += right[1];
        }

        maxAvg = Math.max(maxAvg, sum / count);
        return new Double[]{sum, count};
    }
}
