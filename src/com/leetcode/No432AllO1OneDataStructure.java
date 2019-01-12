package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No432AllO1OneDataStructure {
    class Node {
        int val;
        Node prev, next;
        Set<String> keys;

        Node(String k, int v) {
            val = v;

            keys = new HashSet<>();
            keys.add(k);
        }
    }

    final Map<String, Node> keyMap = new HashMap<>();
    final Map<Integer, Node> valueMap = new HashMap<>();
    final Node head = new Node("", 0), tail = new Node("", 0);

    /**
     * Initialize your data structure here.
     */
    public No432AllO1OneDataStructure() {
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        Node node;
        if (keyMap.containsKey(key)) {
            node = keyMap.get(key);
            int nextValue = node.val + 1;

            if (node.prev.val == nextValue) {
                Node nextNode = node.prev;
                nextNode.keys.add(key);
                keyMap.put(key, nextNode);
            } else {
                Node nextNode = new Node(key, nextValue);
                valueMap.put(nextValue, nextNode);
                keyMap.put(key, nextNode);

                addGreaterNode(nextNode, node);
            }

            node.keys.remove(key);
            if (node.keys.isEmpty()) {
                valueMap.remove(node.val);
                removeNode(node);
            }
        } else {
            if (valueMap.containsKey(1)) {
                node = valueMap.get(1);
                node.keys.add(key);

                keyMap.put(key, node);
            } else {
                node = new Node(key, 1);

                valueMap.put(node.val, node);
                keyMap.put(key, node);

                addGreaterNode(node, tail);
            }

        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = null;
        node.next = null;
    }

    private void addGreaterNode(Node node, Node smallerNode) {
        node.prev = smallerNode.prev;
        node.next = smallerNode;
        smallerNode.prev.next = node;
        smallerNode.prev = node;
    }

    private void addSmallerNode(Node node, Node greaterNode) {
        node.prev = greaterNode;
        node.next = greaterNode.next;

        greaterNode.next.prev = node;
        greaterNode.next = node;
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.keys.remove(key);

            int nextValue = node.val - 1;
            if (nextValue == 0) keyMap.remove(key);
            else {
                if (node.next.val == nextValue) {
                    Node nextNode = node.next;
                    nextNode.keys.add(key);
                    keyMap.put(key, nextNode);
                } else {
                    Node nextNode = new Node(key, nextValue);
                    addSmallerNode(nextNode, node);

                    valueMap.put(nextValue, nextNode);
                    keyMap.put(key, nextNode);
                }
            }

            if (node.keys.isEmpty()) {
                valueMap.remove(node.val);
                removeNode(node);
            }
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return tail == head.next ? "" : tail.prev.keys.iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return tail == head.next ? "" : tail.prev.keys.iterator().next();
    }

    public static void main(String[] args) {
        No432AllO1OneDataStructure solution = new No432AllO1OneDataStructure();
        solution.inc("a");
        solution.inc("b");
        solution.inc("c");
        solution.inc("d");
        solution.inc("a");
        solution.inc("b");
        solution.inc("c");
        solution.inc("d");
        solution.inc("c");
        solution.inc("d");
        solution.inc("d");
        solution.inc("a");
        solution.getMinKey();
    }
}
