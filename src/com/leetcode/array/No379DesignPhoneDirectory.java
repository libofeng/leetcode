package com.leetcode.array;

public class No379DesignPhoneDirectory {

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    private int[] next;
    private int pos;

    public No379DesignPhoneDirectory(int maxNumbers) {
        next = new int[maxNumbers];
        for (int i = 0; i < next.length; i++) next[i] = (i + 1) % maxNumbers;
        pos = 0;
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (next[pos] == -1) return -1;

        int n = pos;
        pos = next[n];
        next[n] = -1;
        return n;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return next[number] > -1;
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        if (number < 0 || number >= next.length || next[number] > -1) return;

        next[number] = pos;
        pos = number;
    }
}
