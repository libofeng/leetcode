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

        int rightNumbers = end - pIndex + 1;
        if (rightNumbers == k) return nums[pIndex];
        else if (rightNumbers > k) return quickSelect(nums, pIndex + 1, end, k);
        else return quickSelect(nums, start, pIndex - 1, k - rightNumbers);
    }

    private int partition(int[] nums, int start, int end) {
        Random rnd = new Random();
        int pIndex = rnd.nextInt(end - start + 1) + start;
        swap(nums, pIndex, end);

        int left = start, right = end - 1, pivot = nums[end];
        while (left <= right) {
            if (nums[right] > pivot) right--;
            else swap(nums, left++, right);
        }
        swap(nums, left, end);
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // ------------------------------------------------

    // https://github.com/interviewdiscussion/files/blob/master/Facebook_java%2Bpdf/215.%20Kth%20Largest%20Element%20in%20an%20Array.java
    public int findKthLargest3(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return 0;
        }
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(i);
                continue;
            }
            if (i > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(i);
            }
        }
        return minHeap.poll();
    }
}
