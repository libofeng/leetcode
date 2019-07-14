package com.leetcode.contest.contest145;

import java.util.*;

public class No1122RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        final TreeMap<Integer, Integer> tm;
        tm = new TreeMap<>();
        for (int n : arr1) tm.put(n, tm.getOrDefault(n, 0) + 1);

        final int[] result = new int[arr1.length];
        int index = 0;
        for (int n : arr2) {
            for (int i = 0; i < tm.getOrDefault(n, 0); i++) result[index++] = n;
            tm.remove(n);
        }

        for (Map.Entry<Integer, Integer> e : tm.entrySet()) {
            for (int i = 0; i < e.getValue(); i++) result[index++] = e.getKey();
        }

        return result;
    }


    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) map.put(arr2[i], i);

        final List<Integer> list = new ArrayList<>(arr1.length);
        for (int n : arr1) list.add(n);

        list.sort((a, b) -> {
            int i = map.getOrDefault(a, arr2.length);
            int j = map.getOrDefault(b, arr2.length);

            return i == j ? (a - b) : (i - j);
        });

        final int[] result = new int[list.size()];
        int index = 0;
        for (int n : list) result[index++] = n;
        return result;
    }
}
