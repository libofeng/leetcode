package com.leetcode.array;

import java.util.Random;
import java.util.TreeMap;

public class No528RandomPickWithWeightBIT {

    private TreeMap<Integer, Integer> tm = new TreeMap<>();
    private Random rnd = new Random();
    private int sum = 0;
    public No528RandomPickWithWeightBIT(int[] w) {
        for(int i = 0;i<w.length;i++) {
            sum += w[i];
            tm.put(sum, i);
        }
    }

    public int pickIndex() {
        return tm.ceilingEntry(rnd.nextInt(sum) + 1).getValue();
    }
}
