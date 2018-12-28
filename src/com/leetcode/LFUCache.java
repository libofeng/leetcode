package com.leetcode;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    int capacity;
    FrequentSlot slotHead = new FrequentSlot(0), slotTail = new FrequentSlot(0);
    final Map<Integer, Cache> cacheMap = new HashMap<>();
    final Map<Cache, FrequentSlot> slotMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
        slotHead.next = slotTail;
        slotTail.prev = slotHead;

    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) return -1;

        Cache cache = cacheMap.get(key);
        updateFrequency(cache);

        return cache.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cacheMap.containsKey(key)) {
            Cache cache = cacheMap.get(key);
            cache.value = value;

            updateFrequency(cache);
        } else addCache(key, value);
    }

    private void removeCache(Cache cache) {
        FrequentSlot slot = slotMap.get(cache);
        slotMap.remove(cache);
        cacheMap.remove(cache.key);

        slot.remove(cache);
        if (slot.isEmpty()) slot.remove();
    }

    private void updateFrequency(Cache cache) {
        FrequentSlot slot = slotMap.get(cache), nextSlot = slot.next;
        if (slot.getTimes() + 1 != nextSlot.getTimes()) nextSlot = slot.addSlotAfter();

        removeCache(cache);

        nextSlot.add(cache);
        cacheMap.put(cache.key, cache);
        slotMap.put(cache, nextSlot);
    }

    private void addCache(int key, int value) {
        while (cacheMap.size() >= capacity) removeCache(slotHead.next.tail.prev);

        Cache cache = new Cache(key, value);

        FrequentSlot slot;
        if (slotHead.next.getTimes() == slotHead.getTimes() + 1) slot = slotHead.next;
        else slot = slotHead.addSlotAfter();

        slot.add(cache);
        cacheMap.put(cache.key, cache);
        slotMap.put(cache, slot);
    }


    class Cache {
        Cache next, prev;
        int key, value;

        Cache(int k, int v) {
            key = k;
            value = v;
        }
    }

    class FrequentSlot {
        Cache head = new Cache(0, 0), tail = new Cache(0, 0);
        FrequentSlot next, prev;
        int size = 0, times = 0;

        FrequentSlot(int t) {
            times = t;

            head.next = tail;
            tail.prev = head;
        }

        void add(Cache cache) {
            cache.next = head.next;
            head.next.prev = cache;
            head.next = cache;
            cache.prev = head;
            size++;
        }

        void remove(Cache cache) {
            cache.next.prev = cache.prev;
            cache.prev.next = cache.next;
            size--;

            cache.prev = null;
            cache.next = null;
        }

        boolean isEmpty() {
            return size == 0;
        }

        private int getTimes() {
            return times;
        }

        FrequentSlot addSlotAfter() {
            FrequentSlot slot = new FrequentSlot(getTimes() + 1);
            slot.next = next;
            next.prev = slot;
            next = slot;
            slot.prev = this;

            return slot;
        }

        void remove() {
            if (next != null) next.prev = prev;
            if (prev != null) prev.next = next;

            next = null;
            prev = null;
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(2, 2);
        lfuCache.put(1, 1);
        lfuCache.get(1);
        lfuCache.get(2);

        lfuCache.put(3, 3);
        lfuCache.put(4, 4);
        lfuCache.get(2);
        lfuCache.get(1);
        lfuCache.get(4);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */