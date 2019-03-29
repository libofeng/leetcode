package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class No170TwoSumIIIDataStructureDesign {
    /*
    Design and implement a TwoSum class. It should support the following operations: add and find.

    add - Add the number to an internal data structure.
    find - Find if there exists any pair of numbers which sum is equal to the value.

    Example 1:

    add(1); add(3); add(5);
    find(4) -> true
    find(7) -> false

    Example 2:

    add(3); add(1); add(2);
    find(3) -> true
    find(6) -> false
     */

    private final Map<Integer, Integer> map = new HashMap<>();

    void add(int v) {
        map.put(v, map.getOrDefault(v, 0) + 1);
    }

    boolean find(int v) {
        for (int key : map.keySet()) {
            int t = v - key;
            if ((t == key && map.get(key) > 1) || (t != key && map.containsKey(t))) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        No170TwoSumIIIDataStructureDesign solution = new No170TwoSumIIIDataStructureDesign();
        solution.add(1);
        solution.add(3);
        solution.add(2);
        System.out.println("solution.find(4) = " + solution.find(4));
        System.out.println("solution.find(7) = " + solution.find(7));
        System.out.println("solution.find(3) = " + solution.find(3));
        System.out.println("solution.find(6) = " + solution.find(6));

    }
}
