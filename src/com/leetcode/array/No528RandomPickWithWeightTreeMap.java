package com.leetcode.array;

import java.util.Random;
import java.util.TreeMap;

public class No528RandomPickWithWeightTreeMap {

    private TreeMap<Integer, Integer> tm = new TreeMap<>();
    private Random rnd = new Random();
    private int totalSum = 0;

    public No528RandomPickWithWeightTreeMap(int[] w) {
        for (int i = 0; i < w.length; i++) tm.put((totalSum += w[i]), i);
    }

    public int pickIndex() {
        return tm.ceilingEntry(rnd.nextInt(totalSum) + 1).getValue();
    }
}
