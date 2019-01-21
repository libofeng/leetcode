package com.leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class No215KthLargestElementInAnArray {


    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // ------------------------------------------------
    public int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        int pIndex = partition(nums, start, end);

        int right = end - pIndex + 1;
        if (right == k) return nums[pIndex];
        else if (right > k) return quickSelect(nums, pIndex + 1, end, k);
        else return quickSelect(nums, start, pIndex - 1, k - right);
    }

    private int partition(int[] nums, int start, int end) {
        int lo = start, hi = end - 1, pivot = nums[end];
        while (lo <= hi) {
            if (nums[lo] < pivot) lo++;
            else swap(nums, lo, hi--);
        }

        swap(nums, lo, end);
        return lo;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // ------------------------------------------------

    // https://github.com/interviewdiscussion/files/blob/master/Facebook_java%2Bpdf/215.%20Kth%20Largest%20Element%20in%20an%20Array.java
    public int findKthLargest3(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return 0;

        Queue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            if (pq.size() < k || n > pq.peek()) pq.offer(n);
            if (pq.size() > k) pq.poll();
        }

        return pq.peek();
    }
}
