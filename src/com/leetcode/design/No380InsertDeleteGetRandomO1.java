package com.leetcode.design;

import java.util.*;

public class No380InsertDeleteGetRandomO1 {
    /**
     * Initialize your data structure here.
     */
    private final List<Integer> list = new ArrayList<>();
    private final Map<Integer, Integer> map = new HashMap<>();
    private final Random rnd = new Random();

    public No380InsertDeleteGetRandomO1() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        map.put(val, list.size());
        list.add(val);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int valIndex = map.get(val);
        map.remove(val);

        if (valIndex != list.size() - 1) {
            list.set(valIndex, list.get(list.size() - 1));
            map.put(list.get(valIndex), valIndex);
        }
        list.remove(list.size() - 1);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rnd.nextInt(list.size()));
    }
}
