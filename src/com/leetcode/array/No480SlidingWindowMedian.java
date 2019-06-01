package com.leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class No480SlidingWindowMedian {
    final Queue<Integer> minHeap = new PriorityQueue<>();
    final Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));


    // Time: O(NK), Space:O(K)
    // since every time remove number from q is O(K)
    public static void main(String[] args) {
        No480SlidingWindowMedian solution = new No480SlidingWindowMedian();
        double[] result = solution.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        final int n = nums.length;
        final double[] result = new double[n - k + 1];

        for (int i = 0; i < n; i++) {
            add(nums[i]);

            int index = i - k + 1;
            if (index >= 0) {
                result[index] = getMedian();
                remove(nums[index]);
            }
        }

        return result;
    }

    private void add(int n) {
        maxHeap.offer(n);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
    }

    private void remove(int n) {
        double median = getMedian();
        if (n <= median) maxHeap.remove(n);
        else minHeap.remove(n);

        if (maxHeap.size() - minHeap.size() > 1) minHeap.offer(maxHeap.poll());
        else if (minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
    }

    private double getMedian() {
        if (minHeap.size() == maxHeap.size()) return ((double) minHeap.peek() + maxHeap.peek()) / 2;
        return maxHeap.peek();
    }
}
