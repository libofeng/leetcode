package com.leetcode.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class No379DesignPhoneDirectory {
    private final int maxNumbers;
    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    private int number = 0;
    private Queue<Integer> recycle = new LinkedList<>();
    private Set<Integer> used = new HashSet<>();

    public No379DesignPhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (used.size() == maxNumbers) return -1;

        int n = recycle.isEmpty() ? number++ : recycle.poll();
        used.add(n);
        return n;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return !used.contains(number);
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        if (used.remove(number)) recycle.offer(number);
    }
}
