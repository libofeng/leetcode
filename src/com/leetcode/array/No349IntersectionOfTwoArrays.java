package com.leetcode.array;

import java.util.*;

public class No349IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int n : nums1) set1.add(n);
        for (int n : nums2) set2.add(n);
        set1.retainAll(set2);

        int[] result = new int[set1.size()];
        int index = 0;
        for (int n : set1) result[index++] = n;

        return result;
    }


    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }

        final int[] result = new int[set.size()];
        int index = 0;
        for (int n : set) result[index++] = n;

        return result;
    }
}
