package com.leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class No215KthLargestElementInAnArray {


    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;

        while (start < end) {
            int pivot = partition(nums, start, end);
            if (pivot > index) end = pivot - 1;
            else if (pivot < index) start = pivot + 1;
            else return nums[pivot];
        }

        return nums[start];
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = start, temp;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) break;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return end;
    }

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
