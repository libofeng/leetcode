package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class No239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums.length < k) return new int[0];

        int[] R = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i - start == k) {
                R[++start] = map.lastKey();

                if (map.get(nums[start]) == 1) map.remove(nums[start]);
                else map.put(nums[start], map.get(nums[start]) - 1);
            }
        }

        return R;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (k == 0 || nums.length < k) return new int[0];

        int[] R = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.getFirst() == i - k) dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) dq.pollLast();
            dq.offer(i);

            int index = i - k + 1;
            if (index >= 0) R[index] = nums[dq.peekFirst()];
        }

        return R;
    }
}
