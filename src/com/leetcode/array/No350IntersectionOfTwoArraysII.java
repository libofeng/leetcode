package com.leetcode.array;

import java.util.*;

public class No350IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        final Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int n : nums1) map1.put(n, map1.getOrDefault(n, 0) + 1);
        for (int n : nums2) map2.put(n, map2.getOrDefault(n, 0) + 1);

        List<Integer> intersection = new ArrayList<>();
        for (int key : map1.keySet()) {
            int c = Math.min(map1.get(key), map2.getOrDefault(key, 0));
            for (int i = 0; i < c; i++) intersection.add(key);
        }

        int[] result = new int[intersection.size()];
        for (int i = 0; i < result.length; i++) result[i] = intersection.get(i);

        return result;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> intersection = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersection.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) i++;
            else j++;
        }

        int[] result = new int[intersection.size()];
        for (int p = 0; p < result.length; p++) result[p] = intersection.get(p);

        return result;
    }

    public int[] intersect3(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect3(nums2, nums1);

        final List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int lastIndex = -1;
        // Note: make sure lastIndex is less than the max index.
        for (int i = 0; i < nums1.length && lastIndex < nums2.length - 1; i++) {
            int index = findIndex(nums2, lastIndex + 1, nums1[i]);
            if (index == -1) continue;

            lastIndex = index;
            list.add(nums1[i]);
        }

        int[] result = new int[list.size()];
        for (int k = 0; k < result.length; k++) result[k] = list.get(k);
        return result;
    }

    private int findIndex(int[] nums, int start, int target) {
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > nums[mid]) lo = mid + 1;
            else hi = mid;
        }

        return nums[lo] == target ? lo : -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{43, 85, 49, 2, 83, 2, 39, 99, 15, 70, 39, 27, 71, 3, 88, 5, 19, 5, 68, 34, 7, 41, 84, 2, 13, 85, 12, 54, 7, 9, 13, 19, 92};
        int[] nums2 = new int[]{10, 8, 53, 63, 58, 83, 26, 10, 58, 3, 61, 56, 55, 38, 81, 29, 69, 55, 86, 23, 91, 44, 9, 98, 41, 48, 41, 16, 42, 72, 6, 4, 2, 81, 42, 84, 4, 13};
        No350IntersectionOfTwoArraysII solution = new No350IntersectionOfTwoArraysII();
        int[] result = solution.intersect3(nums1, nums2);
        System.out.println("result = " + result);
    }
}
