package com.leetcode.array;

public class No556NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        if (n < 10 || n == Integer.MAX_VALUE) return -1;
        char[] chars = ("" + n).toCharArray();

        int dropIndex = chars.length - 2;
        while (dropIndex >= 0 && chars[dropIndex] >= chars[dropIndex + 1]) dropIndex--;
        if (dropIndex < 0) return -1;

        int biggerIndex = chars.length - 1;
        while (chars[biggerIndex] <= chars[dropIndex]) biggerIndex--;
        swap(chars, dropIndex, biggerIndex);
        reverse(chars, dropIndex + 1, chars.length - 1);

        long num = Long.parseLong(new String(chars));
        return num > Integer.MAX_VALUE ? -1 : (int) num;
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) swap(chars, start++, end--);
    }
}
