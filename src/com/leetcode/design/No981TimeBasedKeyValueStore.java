package com.leetcode.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class No981TimeBasedKeyValueStore {

    /**
     * Initialize your data structure here.
     */
    private Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public No981TimeBasedKeyValueStore() {

    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        Map.Entry<Integer, String> e = map.get(key).floorEntry(timestamp);
        return e == null ? "" : e.getValue();
    }
}
