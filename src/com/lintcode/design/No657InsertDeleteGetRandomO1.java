package com.lintcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class No657InsertDeleteGetRandomO1 {
    class Node {
        int idx, val;
        Node prev, next;

        Node(int index, int value) {
            idx = index;
            val = value;
        }
    }

    private Node head = new Node(-1, -1), tail = head;
    ArrayList<Node> list = new ArrayList<>();
    Map<Integer, Node> map = new HashMap<>();

    public No657InsertDeleteGetRandomO1() {

    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        Node node = new Node(list.size(), val);
        list.add(node);
        map.put(val, node);

        tail.next = node;
        node.prev = tail;
        tail = node;

        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        Node node = map.get(val);
        map.remove(val);

        if (node == tail) {
            tail = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = null;
        tail.next = null;

        Node tailNode = list.get(list.size() - 1);
        tailNode.idx = node.idx;
        list.set(tailNode.idx, tailNode);
        list.remove(list.size() - 1);

        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        final Random random = new Random();
        return list.get(random.nextInt(list.size())).val;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */