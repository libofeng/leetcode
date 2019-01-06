package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No969PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();

        int[] sorted = A.clone();
        Arrays.sort(sorted);

        for (int i = sorted.length - 1; i >= 0; i--) {
            int j = i;
            for (; j >= 0; j--) if (A[j] == sorted[i]) break;
            if (i == j) continue;

            reverse(A, 0, j);
            reverse(A, 0, i);

            if (j > 0) result.add(j + 1);
            result.add(i + 1);
        }

        return result;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) swap(nums, i++, j--);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
