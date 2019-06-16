package com.leetcode.contest.contest141;

public class No1089DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int index = 0, len = 0;
        while (len < arr.length) len += arr[index++] == 0 ? 2 : 1;

        for (int i = index - 1, p = len - 1; i >= 0; i--) {
            if (arr[i] == 0 && p-- < arr.length) arr[p + 1] = arr[i];
            arr[p--] = arr[i];
        }
    }
}
