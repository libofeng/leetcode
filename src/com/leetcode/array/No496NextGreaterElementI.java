package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No496NextGreaterElementI {
    // Time:O(N^2)  Space: O(N)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) map.put(nums2[i], i);

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = -1;
            for (int j = map.get(nums1[i]) + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }

        return result;
    }

    // Time:O(N)  Space: O(N)
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        final Stack<Integer> stack = new Stack<>();
        final Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums2) {
            while (!stack.isEmpty() && stack.peek() <= n) map.put(stack.pop(), n);
            stack.push(n);
        }

        final int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) result[i] = map.getOrDefault(nums1[i], -1);

        return result;
    }
}
