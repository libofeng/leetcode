package com.lintcode.array;

class NumArray {
    int[] BIT, nums;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.BIT = new int[n + 1];

        for (int i = 0; i < n; i++) init(i, nums[i]);
    }

    private void init(int i, int val) {
        for (i++; i <= n; i += (i & -i)) BIT[i] += val;
    }

    public void update(int i, int val) {
        int delta = val - nums[i];
        init(i, delta);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return query(j) - query(i - 1);
    }

    private int query(int i) {
        int sum = 0;
        for (i++; i > 0; i -= (i & -i)) sum += BIT[i];
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */