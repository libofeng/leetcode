package com.leetcode.list;

import java.util.HashMap;
import java.util.Map;

public class No146LRUCache {
    class Cache {
        int key, value;
        Cache prev, next;

        Cache(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Map<Integer, Cache> map = new HashMap<>();
    private Cache head = new Cache(0, 0), tail = new Cache(0, 0);
    private int capacity;

    public No146LRUCache(int capacity) {
        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;
    }

    private void removeCache(Cache cache) {
        map.remove(cache.key);

        cache.next.prev = cache.prev;
        cache.prev.next = cache.next;
        cache.next = null;
        cache.prev = null;
    }

    private void addCache(Cache cache) {
        while (map.size() >= capacity) removeCache(tail.prev);
        map.put(cache.key, cache);

        cache.next = head.next;
        cache.prev = head;

        cache.next.prev = cache;
        cache.prev.next = cache;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Cache cache = map.get(key);
        removeCache(cache);
        addCache(cache);

        return cache.value;
    }

    public void put(int key, int value) {
        Cache cache;
        if (map.containsKey(key)) {
            cache = map.get(key);
            cache.value = value;

            removeCache(cache);
        } else cache = new Cache(key, value);

        addCache(cache);
    }
}
