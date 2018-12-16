package com.lintcode.list;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class No528FlattenNestedListIterator implements Iterator<Integer> {

    private Deque<NestedInteger> dq = new LinkedList<>();

    public No528FlattenNestedListIterator(List<NestedInteger> nestedList) {
        for (NestedInteger i : nestedList) dq.offerLast(i);
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        return hasNext() ? dq.poll().getInteger() : null;
    }

    private void flatten() {
        while (!dq.isEmpty() && !dq.peek().isInteger()) {
            List<NestedInteger> list = dq.poll().getList();
            for (int i = list.size() - 1; i >= 0; i--) dq.offerFirst(list.get(i));
        }
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        flatten();
        return !dq.isEmpty();
    }

    @Override
    public void remove() {
    }
}
