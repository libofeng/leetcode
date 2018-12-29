package com.leetcode.array;

import java.util.*;

public class No251Flatten2DVector implements Iterator<Integer> {
    private List<List<Integer>> list;
    private int row, col;

    public No251Flatten2DVector(List<List<Integer>> vec2d) {
        this.list = vec2d;
    }

    @Override
    public Integer next() {
        if (!hasNext()) return -1;
        return list.get(row).get(col++);
    }

    @Override
    public boolean hasNext() {
        while (row < list.size()) {
            if (col < list.get(row).size()) return true;
            else {
                row++;
                col = 0;
                return hasNext();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(Arrays.asList(1, 2));
        list.add(Collections.singletonList(3));
        list.add(Arrays.asList(4, 5, 6));
        No251Flatten2DVector iterator = new No251Flatten2DVector(list);
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
    }
}