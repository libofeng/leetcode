package com.leetcode.array;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class No341FlattenNestedListIterator implements Iterator<Integer> {

    private Deque<NestedInteger> dq = new LinkedList<>();

    public No341FlattenNestedListIterator(List<NestedInteger> nestedList) {
        dq.addAll(nestedList);
    }

    private void flatten() {
        while (!dq.isEmpty() && !dq.peek().isInteger()) {
            List<NestedInteger> list = dq.poll().getList();
            for (int i = list.size() - 1; i >= 0; i--) dq.addFirst(list.get(i));
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) return null;

        return dq.poll().getInteger();
    }

    @Override
    public boolean hasNext() {
        flatten();
        return !dq.isEmpty();
    }
}
