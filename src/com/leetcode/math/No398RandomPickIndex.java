package com.leetcode.math;

import java.util.*;

public class No398RandomPickIndex {

    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Random rnd = new Random();

    public No398RandomPickIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
    }

    public int pick(int target) {
        final List<Integer> list = map.get(target);
        return list.get(rnd.nextInt(list.size()));
    }
}
