package com.lintcode.list;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    final Deque<NestedInteger> dq = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger item : nestedList) dq.offer(item);
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        return hasNext() ? dq.poll().getInteger() : null;
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        flatten();
        return !dq.isEmpty();
    }

    private void flatten() {
        while (!dq.isEmpty()) {
            NestedInteger item = dq.peek();
            if (item.isInteger()) return;

            dq.poll();
            List<NestedInteger> list = item.getList();
            for (int i = list.size() - 1; i >= 0; i--) dq.offerFirst(list.get(i));
        }
    }

    @Override
    public void remove() {
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */