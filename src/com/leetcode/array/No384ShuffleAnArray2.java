package com.leetcode.array;

import java.util.Random;

public class No384ShuffleAnArray2 {
    // solution 2:
    // shuffle方法：先用 orgn[] 数组初始化 cur[] 数组，然后从右往左遍历 cur[] 数组，即cur[i]，i 从 len-1 到 0，
    // 对于cur[i] ，任何 cur[j]，（j<=i），cur[j] 都有 1/(i+1)的可能性与cur[i] 进行交换。


    private int[] orig;
    private Random rnd = new Random();

    public No384ShuffleAnArray2(int[] nums) {
        orig = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return orig;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] nums = orig.clone();
        for (int i = nums.length - 1; i >= 0; i--) {
            int j = rnd.nextInt(i + 1);
            swap(nums, i, j);
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
