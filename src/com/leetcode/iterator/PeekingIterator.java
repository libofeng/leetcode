package com.leetcode.iterator;

import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private int val = -1;
    private boolean hasNext;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;

        hasNext = iterator.hasNext();
        if (hasNext) val = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return val;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int value = val;

        hasNext = iterator.hasNext();
        if (hasNext) val = iterator.next();

        return value;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }
}
