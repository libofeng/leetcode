package com.leetcode.list;

import java.util.HashMap;
import java.util.Map;

public class No146LRUCache {
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    class Node {
        Node prev, next;
        int key, val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public No146LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        setHead(node);

        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            map.put(key, node);

            if (map.size() > capacity) {
                map.remove(tail.key);
                remove(tail);
            }
        } else {
            node.val = value;
            remove(node);
        }

        setHead(node);
    }

    private void remove(Node node) {
        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = node.next;
            node.next.prev = null;
        } else if (node == tail) {
            tail = node.prev;
            node.prev.next = null;
            node.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.next = null;
        node.prev = null;
    }

    private void setHead(Node node) {
        if (tail == null) {
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
        }

        head = node;
    }
}
