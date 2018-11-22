package com.lintcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class No657InsertDeleteGetRandomO1 {
    private final Map<Integer, Integer> map = new HashMap<>();
    private final ArrayList<Integer> list = new ArrayList<>();
    private final Random rnd = new Random();

    public No657InsertDeleteGetRandomO1() {

    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        map.put(val, list.size());
        list.add(val);

        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int idx = map.get(val), lastIdx = list.size() - 1;
        map.remove(val);
        if (idx < lastIdx) {
            int lastVal = list.get(lastIdx);
            list.set(idx, lastVal);
            map.put(lastVal, idx);
        }
        list.remove(lastIdx);

        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        return list.get(rnd.nextInt(list.size()));
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */