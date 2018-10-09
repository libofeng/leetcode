package com.leetcode.tree;

public class No307RangeSumQueryMutableBIT {
    int[] BIT;
    int[] nums;
    int n;

    public No307RangeSumQueryMutableBIT(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.BIT = new int[n + 1];
        for (int i = 0; i < n; i++) init(i, nums[i]);
    }

    /*
    lowbit(x) = x - (x & (x - 1))
    OR
    lowbit(x) = x & -x
     */
    private void init(int i, int val) {
        for (i++; i <= n; i += (i & -i)) BIT[i] += val;
    }

    public void update(int i, int val) {
        int delta = val - nums[i];
        init(i, delta);
        nums[i] = val;
    }

    private int query(int i) {
        int sum = 0;
        for (i++; i > 0; i -= (i & -i)) sum += BIT[i];
        return sum;
    }

    public int sumRange(int i, int j) {
        return query(j) - query(i - 1);
    }
}
