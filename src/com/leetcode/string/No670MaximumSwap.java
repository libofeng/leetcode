package com.leetcode.string;

import java.util.Arrays;

public class No670MaximumSwap {
    public int maximumSwap(int num) {
        final char[] chars = ("" + num).toCharArray();
        final int len = chars.length;

        for (int i = 0; i < len; i++) {
            int right = i;
            for (int j = len - 1; j > i; j--) if (chars[j] > chars[right]) right = j;
            if (right > i) {
                char tmp = chars[i];
                chars[i] = chars[right];
                chars[right] = tmp;

                return Integer.parseInt(new String(chars));
            }
        }

        return num;
    }

    public int maximumSwap2(int num) {
        final char[] chars = ("" + num).toCharArray();
        final char[] sorted = chars.clone();
        final int len = chars.length;
        Arrays.sort(sorted);
        for (int i = 0; i < len; i++) {
            if (chars[i] == sorted[len - i - 1]) continue;

            // could be optimized by using a map
            for (int j = len - 1; j > i; j--) {
                if (chars[j] != sorted[len - i - 1]) continue;

                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                return Integer.parseInt(new String(chars));
            }
        }

        return num;
    }

    // O(N)
    // https://leetcode.com/problems/maximum-swap/discuss/107068/Java-simple-solution-O(n)-time
    public int maximumSwap3(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }

        return num;
    }
}
