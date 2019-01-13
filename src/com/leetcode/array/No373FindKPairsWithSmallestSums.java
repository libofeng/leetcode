package com.leetcode.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class No373FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        final List<int[]> list = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) return list;

        final Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] + a[1] - b[0] - b[1];
            }
        };
        final PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
        for (int i = 0; i < nums1.length && i < k; i++) pq.offer(new int[]{nums1[i], nums2[0], 0});
        while (!pq.isEmpty() && k-- > 0) {
            int[] pair = pq.poll();
            int n1 = pair[0], n2 = pair[1], i2 = pair[2];
            list.add(new int[]{n1, n2});

            if (i2 + 1 < nums2.length) pq.offer(new int[]{n1, nums2[i2 + 1], i2 + 1});
        }

        return list;
    }
}
