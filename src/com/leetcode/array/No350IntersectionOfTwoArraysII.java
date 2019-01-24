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
}
