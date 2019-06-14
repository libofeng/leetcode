package com.leetcode.random;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class No519RandomFlipMatrix {

    private int rows, cols, n, index;
    private Map<Integer, Integer> map = new HashMap<>();
    private Random rnd = new Random();

    public No519RandomFlipMatrix(int n_rows, int n_cols) {
        rows = n_rows;
        cols = n_cols;
        n = rows * cols;
        index = n;
    }

    public int[] flip() {
        int random = rnd.nextInt(index--), validRandom = map.getOrDefault(random, random);
        map.put(random, map.getOrDefault(index, index));

        return new int[]{validRandom / cols, validRandom % cols};
    }

    public void reset() {
        index = n;
        map.clear();
    }
}
