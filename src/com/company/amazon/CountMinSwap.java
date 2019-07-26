package com.company.amazon;

import java.util.*;

public class CountMinSwap {
    // count the min swap times to make an array sorted
    // see also:
    // https://www.youtube.com/watch?v=f7IIW0HVUcQ

    int counter = 0;

    public static void main(String[] args) {
        CountMinSwap solution = new CountMinSwap();
        int count = solution.count(new int[]{8, 6, 9, 5, 10, 7, 11});
        System.out.println("count = " + count);

        count = solution.count(new int[]{5, 6, 8, 3, 7, 4, 1});
        System.out.println("count = " + count);

        count = solution.count(new int[]{4, 3, 2, 1});
        System.out.println("count = " + count);

        count = solution.count(new int[]{1, 5, 4, 3, 2});
        System.out.println("count = " + count);

        count = solution.count(new int[]{1, 12, 3});
        System.out.println("count = " + count);

        count = solution.count(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println("count = " + count);

        count = solution.count(new int[]{1});
        System.out.println("count = " + count);
    }

    private int count(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], sorted[i]);

        final Set<Integer> visited = new HashSet<>();
        int total = 0;
        for (int num : nums) {
            if (!visited.add(num) || !visited.add(map.get(num))) continue;
            if (num == map.get(num)) continue;

            int len = 2, mapping = map.get(num);
            while (map.get(mapping) != num) {
                len++;
                mapping = map.get(mapping);
                visited.add(mapping);
            }

            total += len - 1;
        }

        return total;
    }

    private int count2(int[] nums) {
        counter = 0;
        quickSort(nums, 0, nums.length - 1);
        return counter;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pIndex = partition(nums, start, end);

        quickSort(nums, start, pIndex - 1);
        quickSort(nums, pIndex + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int lo = start, hi = end - 1, pivot = nums[end];
        while (lo <= hi) {
            if (nums[lo] < pivot) lo++;
            else if (nums[hi] >= pivot) hi--;
            else swap(nums, lo++, hi--);
        }
        if (nums[lo] != nums[end]) swap(nums, lo, end);

        return lo;
    }

    private void swap(int[] nums, int i, int j) {
        counter++;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
