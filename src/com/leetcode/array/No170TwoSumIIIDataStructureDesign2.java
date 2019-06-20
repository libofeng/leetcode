package com.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No170TwoSumIIIDataStructureDesign2 {
    /**
     * Initialize your data structure here.
     */
    private Map<Integer, Integer> map = new HashMap<>();
    private List<Integer> list = new ArrayList<>();

    public No170TwoSumIIIDataStructureDesign2() {
        // this solution is faster than another one due to the iteration of list instead of map
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        if (map.containsKey(number)) map.put(number, map.get(number) + 1);
        else {
            map.put(number, 1);
            list.add(number);
        }
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i), target = value - n, count = map.getOrDefault(target, 0);
            if (target == n && count > 1 || target != n && count > 0) return true;
        }

        return false;
    }
}
