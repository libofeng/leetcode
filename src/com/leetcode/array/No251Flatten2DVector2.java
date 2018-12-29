package com.leetcode.array;

import java.util.*;

public class No251Flatten2DVector2 implements Iterator<Integer> {
    private List<Iterator<Integer>> iterators = new LinkedList<>();
    Iterator<Iterator<Integer>> iterator;
    Iterator<Integer> i;

    public No251Flatten2DVector2(List<List<Integer>> vec2d) {
        for (List<Integer> list : vec2d) iterators.add(list.iterator());
        iterator = iterators.iterator();
    }

    @Override
    public Integer next() {
        if (!hasNext()) return -1;
        return i.next();
    }

    @Override
    public boolean hasNext() {
        if (i != null && i.hasNext()) return true;

        if (iterator.hasNext()) {
            i = iterator.next();
            return hasNext();
        }

        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(Arrays.asList(1, 2));
        list.add(Collections.singletonList(3));
        list.add(Arrays.asList(4, 5, 6));
        No251Flatten2DVector2 iterator = new No251Flatten2DVector2(list);
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
    }
}