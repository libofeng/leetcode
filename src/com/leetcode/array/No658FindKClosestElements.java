package com.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No658FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = findIndex(arr, x);
        int lo = index, hi = index + 1;
        while (k-- > 0) {
            if (lo < 0) hi++;
            else if (hi >= arr.length) lo--;
            else if (Math.abs(x - arr[lo]) <= Math.abs(x - arr[hi])) lo--;
            else hi++;
        }

        List<Integer> R = new ArrayList<>();
        for (int i = lo + 1; i < hi; i++) R.add(arr[i]);
        return R;
    }

    private int findIndex(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x) return mid;
            if (x < arr[mid]) hi = mid - 1;
            else lo = mid + 1;
        }

        return lo;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int n : arr) list.add(n);

        while (list.size() > k) {
            if (x - list.getFirst() > list.getLast() - x) list.removeFirst();
            else list.removeLast();
        }

        return list;
    }
}
