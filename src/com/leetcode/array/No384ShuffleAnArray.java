package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class No384ShuffleAnArray {
    // solution 1:
    /*
    对一组不包含重复元素的数组进行随机重排，reset方法返回最原始的数组，shuffle方法随机返回数组的一个排列，

    并且使得获得数组每一个排列的概率都是相同的。为此，可以在初始化时，求出数组的所有排列。在使用shuffle方法时，随机返回全排列中的一个。
     */
    private List<int[]> permutations = new ArrayList<>();
    private int N;
    private Random rnd = new Random();


    // MLE, not a good solution
    public No384ShuffleAnArray(int[] nums) {
        N = nums.length;
        generate(nums, new boolean[N], new int[N], 0);
    }

    private void generate(int[] nums, boolean[] used, int[] p, int index) {
        if (index == p.length) {
            permutations.add(p.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            p[index] = nums[i];
            generate(nums, used, p, index + 1);
            used[i] = false;
        }
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return N == 0 ? new int[0] : permutations.get(0);
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        return N == 0 ? new int[0] : permutations.get(rnd.nextInt(N));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
