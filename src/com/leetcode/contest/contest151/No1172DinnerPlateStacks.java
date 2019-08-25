package com.leetcode.contest.contest151;

import java.util.*;

public class No1172DinnerPlateStacks {
    private int capacity;
    private List<Stack<Integer>> list = new ArrayList<>();
    private Set<Integer> available = new TreeSet<>();

    public No1172DinnerPlateStacks(int capacity) {
        this.capacity = capacity;
    }

    // Log(N)
    public void push(int val) {
        if (available.isEmpty()) {
            list.add(new Stack<>());
            available.add(list.size() - 1);
        }

        Iterator<Integer> iterator = available.iterator();
        int index = iterator.next();
        Stack<Integer> stack = list.get(index);

        stack.push(val);
        if (stack.size() == capacity) available.remove(index);
    }

    // O(N)
    public int pop() {
        if (list.isEmpty()) return -1;

        int val = list.get(list.size() - 1).pop();
        removeEmpty();

        return val;
    }

    // Log(N)
    public int popAtStack(int index) {
        if (index >= list.size() || index < 0) return -1;

        Stack<Integer> stack = list.get(index);
        int val = stack.isEmpty() ? -1 : stack.pop();
        available.add(index);

        removeEmpty();
        return val;
    }

    // O(N)
    private void removeEmpty() {
        while (list.size() > 0 && list.get(list.size() - 1).isEmpty()) {
            int index = list.size() - 1;
            list.remove(index);
            available.remove(index);
        }
    }
}
