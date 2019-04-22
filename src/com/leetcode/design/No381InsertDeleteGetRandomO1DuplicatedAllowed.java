package com.leetcode.design;

import java.util.*;

public class No381InsertDeleteGetRandomO1DuplicatedAllowed {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random rnd;

    /**
     * Initialize your data structure here.
     */
    public No381InsertDeleteGetRandomO1DuplicatedAllowed() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rnd = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean result = !map.containsKey(val);

        // the key to this problem is to use a LinkedHashSet since we need to remove index by value
        map.computeIfAbsent(val, k -> new LinkedHashSet<>()).add(list.size());
        list.add(val);

        return result;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        Set<Integer> indexSet = map.get(val);
        int index = indexSet.iterator().next(), lastIndex = list.size() - 1;
        // the val index should be removed, otherwise there will be problem when val == lastVal
        indexSet.remove(index);

        if (index != lastIndex) {
            int lastVal = list.get(lastIndex);
            list.set(index, lastVal);

            Set<Integer> lastIndexList = map.get(lastVal);
            lastIndexList.remove(lastIndex);
            lastIndexList.add(index);
        }

        list.remove(lastIndex);
        if (indexSet.isEmpty()) map.remove(val);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(rnd.nextInt(list.size()));
    }

    public static void main(String[] args) {
        No381InsertDeleteGetRandomO1DuplicatedAllowed solution = new No381InsertDeleteGetRandomO1DuplicatedAllowed();
        solution.insert(4);
        solution.insert(3);
        solution.insert(4);
        solution.insert(2);
        solution.insert(4);

        solution.remove(4);
        solution.remove(3);
        solution.remove(4);
        solution.remove(4);
    }
}
