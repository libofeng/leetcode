package com.leetcode.random;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class No710RandomPickWithBlacklist {
    private Map<Integer, Integer> map = new HashMap<>();
    private Random rnd = new Random();
    private int total = 0;

    public No710RandomPickWithBlacklist(int N, int[] blacklist) {
        for (int b : blacklist) map.put(b, -1);
        total = N - map.size();

        int n = N - 1;
        for (int b : blacklist) {
            if (b < total) {
                while (map.containsKey(n)) n--;
                map.put(b, n--);
            }
        }
    }

    public int pick() {
        int n = rnd.nextInt(total);
        return map.getOrDefault(n, n);
    }
}
