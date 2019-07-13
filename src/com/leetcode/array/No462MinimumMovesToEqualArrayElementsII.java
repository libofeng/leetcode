package com.leetcode.array;

import java.util.Arrays;

public class No462MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int i = 0, j = nums.length - 1, count = 0;
        while (i < j) count += nums[j--] - nums[i++];

        return count;
    }

    public int minMoves22(int[] nums) {
        final int n = nums.length;
        int medium = findKth(nums, 0, n - 1, n / 2 + 1);
        if(n % 2 == 0) medium = (medium + findKth(nums, 0, n - 1, n / 2)) / 2;

        int count = 0;
        for(int num : nums) count += Math.abs(medium - num);
        return count;
    }

    private int findKth(int[] nums, int start, int end, int k){
        int pivot = nums[end], lo = start, hi = end - 1;

        while(lo<=hi){
            if(nums[lo]<pivot) lo++;
            else if(nums[hi]>=pivot) hi--;
            else swap(nums, lo, hi--);
        }
        swap(nums, lo, end);

        int left = lo - start + 1;
        if(k == left) return nums[lo];
        else if(k>left) return findKth(nums, lo + 1, end, k - left);
        else return findKth(nums, start, lo-1, k);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
