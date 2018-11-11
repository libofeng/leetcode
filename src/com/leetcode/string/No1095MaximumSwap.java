package com.leetcode.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class No1095MaximumSwap {
    /**
     * @param num: a non-negative intege
     * @return: the maximum valued number
     */
    public int maximumSwap(int num) {
        char[] chars = ("" + num).toCharArray();

        int len = chars.length;
        for (int i = 0; i < len; i++) {
            int right = i;
            for (int j = len - 1; j > i; j--) if (chars[j] > chars[right]) right = j;
            if (right > i) {
                swap(chars, i, right);
                return Integer.parseInt(new String(chars));
            }
        }

        return num;
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }


    public int maximumSwap2(int num) {
        final char[] origin = ("" + num).toCharArray();
        final char[] sorted = ("" + num).toCharArray();
        final int len = sorted.length;
        Arrays.sort(sorted);

        for (int i = len - 1; i >= 0; i--) {
            if (sorted[i] != origin[len - i - 1]) {
                for (int j = len - 1; j > len - i - 1; j--) {
                    if (origin[j] == sorted[i]) {
                        char tmp = origin[i];
                        origin[i] = origin[j];
                        origin[j] = tmp;
                        return Integer.parseInt(new String(origin));
                    }
                }
            }
        }

        return num;
    }

    public int maximumSwap3(int num) {
        final char[] origin = ("" + num).toCharArray();
        final char[] sorted = ("" + num).toCharArray();
        final int len = sorted.length;
        Arrays.sort(sorted);
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < len; i++) indexMap.put(origin[i], i);

        for (int i = len - 1; i >= 0; i--) {
            int oi = len - i - 1;
            if (sorted[i] != origin[oi]) {
                int oj = indexMap.get(sorted[i]);

                char tmp = origin[oi];
                origin[oi] = origin[oj];
                origin[oj] = tmp;
                return Integer.parseInt(new String(origin));
            }
        }

        return num;
    }
}
